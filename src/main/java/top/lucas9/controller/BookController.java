package top.lucas9.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.lucas9.entity.Book;
import top.lucas9.entity.BorrowingRecords;
import top.lucas9.entity.ResultEntity;
import top.lucas9.service.BookService;
import top.lucas9.utils.AuthenticateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author lucas
 */
@RestController
@RequestMapping("/do")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/updateBook")
    public ResultEntity updateBook(@Valid @RequestBody Book book, HttpServletRequest request) {
        AuthenticateUtil.hasRoles(request, Arrays.asList("ADMIN", "SUPER_ADMIN"));
        bookService.updateBook(book);
        return ResultEntity.success("更新成功");
    }

    @RequestMapping("/insertBook")
    public ResultEntity insertBook(@Valid @RequestBody Book book, HttpServletRequest request) {
        AuthenticateUtil.hasRoles(request, Arrays.asList("ADMIN", "SUPER_ADMIN"));
        bookService.insertBook(book);
        return ResultEntity.success("添加成功");
    }

    @RequestMapping("/selectBookByKeyword")
    public ResultEntity<PageInfo<Book>> selectBookByKeyword(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        return ResultEntity.success("查询成功", bookService.selectBookByKeyword(pageNum, pageSize, keyword));
    }

    @RequestMapping("/deleteBook")
    public ResultEntity deleteBook(String isbn) {
        bookService.deleteBook(isbn);
        return ResultEntity.success("删除成功");
    }
    @RequestMapping("/borrowBook")
    public ResultEntity borrowBook(@Valid @RequestBody BorrowingRecords records) {
        bookService.updateBorrowBook(records);
        return ResultEntity.success("借阅成功");
    }
    @RequestMapping("/returnBook")
    public ResultEntity returnBook(@RequestParam("bookId") Integer bookId, @RequestParam("recordId") Integer recordId, @RequestParam("username") String username) {
        bookService.updateReturnBook(bookId, recordId, username);
        return ResultEntity.success("还书成功");
    }

    @RequestMapping("/selectRecordByKeyword")
    public ResultEntity<PageInfo<BorrowingRecords>> selectRecordByKeyword(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "isOneself", defaultValue = "false") String isOneself) {
        return ResultEntity.success("查询成功", bookService.selectRecordByKeyword(pageNum, pageSize, keyword, isOneself));
    }
}
