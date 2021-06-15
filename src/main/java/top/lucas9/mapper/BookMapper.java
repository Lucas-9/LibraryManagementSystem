package top.lucas9.mapper;

import org.apache.ibatis.annotations.Param;
import top.lucas9.entity.Book;
import top.lucas9.entity.BorrowingRecords;

import java.util.List;

public interface BookMapper {
    void insertBook(@Param("book") Book book);
    Integer selectIdByIsbn(@Param("isbn")String isbn);
    void updateBook(@Param("book") Book book);
    List<Book> selectBookByKeyword(@Param("keyword") String keyword);
    void deleteBook(@Param("isbn") String isbn);
    Integer selectBookNumber(@Param("bookId") Integer bookId);
    Integer updateBookBorrowBook(@Param("bookId") Integer bookId);
    Integer updateBookReturnBook(@Param("bookId") Integer bookId);
}
