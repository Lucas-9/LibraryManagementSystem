package top.lucas9.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author lucas
 */
public class Book implements Serializable {
    private Integer id;
    private String coverUrl;
    @NotBlank(message = "书名不能为空")
    private String bookName;
    @NotBlank(message = "作者不能为空")
    private String bookAuthor;
    @Min(value = 1,message = "最少添加1本")
    private Integer quantity;
    @NotBlank(message = "简介不能为空")
    private String introduction;
    @NotBlank(message = "ISBN不能为空")
    private String isbn;
    @NotBlank(message = "价格不能为空")
    private String price;
    @NotBlank(message = "出版社不能为空")
    private String press;

    public Book() {
    }

    public Book(Integer id, String coverUrl, String bookName, String bookAuthor, Integer quantity, String introduction, String isbn, String price, String press) {
        this.id = id;
        this.coverUrl = coverUrl;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.introduction = introduction;
        this.isbn = isbn;
        this.price = price;
        this.press = press;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", coverUrl='" + coverUrl + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", quantity=" + quantity +
                ", introduction='" + introduction + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price='" + price + '\'' +
                ", press='" + press + '\'' +
                '}';
    }
}
