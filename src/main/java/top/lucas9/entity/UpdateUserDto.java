package top.lucas9.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author lucas
 */
public class UpdateUserDto implements Serializable {
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "角色不能为空")
    private String role;
    @Min(30)@Max(90)
    private Integer borrowableDays;
    @Min(3)@Max(10)
    private Integer borrowableNumber;
    @Min(0)@Max(10)
    private Integer borrowedNumber;

    public UpdateUserDto() {
    }

    public UpdateUserDto(Integer id, String username, String role, Integer borrowableDays, Integer borrowableNumber, Integer borrowedNumber) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.borrowableDays = borrowableDays;
        this.borrowableNumber = borrowableNumber;
        this.borrowedNumber = borrowedNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getBorrowableDays() {
        return borrowableDays;
    }

    public void setBorrowableDays(Integer borrowableDays) {
        this.borrowableDays = borrowableDays;
    }

    public Integer getBorrowableNumber() {
        return borrowableNumber;
    }

    public void setBorrowableNumber(Integer borrowableNumber) {
        this.borrowableNumber = borrowableNumber;
    }

    public Integer getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(Integer borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    @Override
    public String toString() {
        return "UpdateUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", borrowableDays=" + borrowableDays +
                ", borrowableNumber=" + borrowableNumber +
                ", borrowedNumber=" + borrowedNumber +
                '}';
    }
}
