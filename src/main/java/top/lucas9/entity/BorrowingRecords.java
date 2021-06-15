package top.lucas9.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author lucas
 */
public class BorrowingRecords implements Serializable {
    private Integer id;
    @NotBlank(message = "书名不能为空")
    private String bookName;
    private Integer bookId;
    @NotBlank(message = "借阅者不能为空")
    private String borrower;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private Integer deadline;
    private Boolean returned;

    public BorrowingRecords() {
    }

    public BorrowingRecords(Integer id, String bookName, Integer bookId, String borrower, LocalDate loanDate, LocalDate returnDate, Integer deadline, Boolean returned) {
        this.id = id;
        this.bookName = bookName;
        this.bookId = bookId;
        this.borrower = borrower;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.deadline = deadline;
        this.returned = returned;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "BorrowingRecords{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookId=" + bookId +
                ", borrower='" + borrower + '\'' +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", deadline=" + deadline +
                ", returned=" + returned +
                '}';
    }
}
