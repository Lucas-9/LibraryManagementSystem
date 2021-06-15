package top.lucas9.service;

import com.github.pagehelper.PageInfo;
import top.lucas9.entity.Book;
import top.lucas9.entity.BorrowingRecords;

import java.util.List;

/**
 * @author lucas
 */
public interface BookService {
    void updateBook(Book book);
    void insertBook(Book book);
    PageInfo<Book> selectBookByKeyword(Integer pageNum, Integer pageSize, String keyword);
    PageInfo<BorrowingRecords> selectRecordByKeyword(Integer pageNum, Integer pageSize, String keyword, String oneself);
    void deleteBook(String isbn);
    void updateBorrowBook(BorrowingRecords records);
    void updateReturnBook(Integer bookId, Integer recordId, String username);
}
