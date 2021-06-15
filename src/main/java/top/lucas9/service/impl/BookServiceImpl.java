package top.lucas9.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.lucas9.entity.Book;
import top.lucas9.entity.BorrowingRecords;
import top.lucas9.entity.User;
import top.lucas9.exception.AuthenticationException;
import top.lucas9.mapper.BookMapper;
import top.lucas9.mapper.RecordMapper;
import top.lucas9.mapper.UserMapper;
import top.lucas9.service.BookService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lucas
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void updateBook(Book book) {
        Integer bookId = bookMapper.selectIdByIsbn(book.getIsbn());
        Assert.notNull(bookId, "该书不存在");
        bookMapper.updateBook(book);
    }

    @Override
    public void insertBook(Book book) {
        Integer bookId = bookMapper.selectIdByIsbn(book.getIsbn());
        Assert.isNull(bookId, "该书已存在");
        bookMapper.insertBook(book);
    }

    @Override
    public PageInfo<Book> selectBookByKeyword(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookMapper.selectBookByKeyword(keyword);
        return new PageInfo<>(books);
    }

    @Override
    public void deleteBook(String isbn) {
        bookMapper.deleteBook(isbn);
    }

    @Override
    public void updateBorrowBook(BorrowingRecords records) {
        User user = userMapper.selectUserByUsername(records.getBorrower());
        if (null == user || user.getBorrowableNumber() == 0) {
            throw new AuthenticationException("无法借阅！");
        }
        Integer userBorrowFlag = userMapper.updateUserBorrowBook(records.getBorrower());
        if (null == userBorrowFlag || userBorrowFlag == 0) {
            throw new AuthenticationException("借阅失败！");
        }
        Integer bookBorrowFlag = bookMapper.updateBookBorrowBook(records.getBookId());
        if (null == bookBorrowFlag || bookBorrowFlag == 0) {
            throw new AuthenticationException("借阅失败！");
        }
        records.setDeadline(user.getBorrowableDays());
        records.setLoanDate(LocalDate.now());
        Integer borrowed = recordMapper.insertRecord(records);
        if (null == borrowed || borrowed == 0) {
            throw new AuthenticationException("借阅失败！");
        }
    }

    @Override
    public void updateReturnBook(Integer bookId, Integer recordId, String username) {
        Integer userReturnFlag = userMapper.updateUserReturnBook(username);
        if (null == userReturnFlag || userReturnFlag == 0) {
            throw new AuthenticationException("还书失败！");
        }
        Integer bookReturnFlag = bookMapper.updateBookReturnBook(bookId);
        if (null == bookReturnFlag || bookReturnFlag == 0) {
            throw new AuthenticationException("还书失败！");
        }
        Integer borrowed = recordMapper.updateRecord(recordId, LocalDate.now());
        if (null == borrowed || borrowed == 0) {
            throw new AuthenticationException("借阅失败！");
        }
    }

    @Override
    public PageInfo<BorrowingRecords> selectRecordByKeyword(Integer pageNum, Integer pageSize, String keyword, String isOneself) {
        PageHelper.startPage(pageNum, pageSize);
        List<BorrowingRecords> books = recordMapper.selectRecordByKeyword(keyword, isOneself);
        return new PageInfo<>(books);
    }
}
