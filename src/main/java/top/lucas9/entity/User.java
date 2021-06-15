package top.lucas9.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lucas
 */
public class User implements Serializable {
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp="^1(3\\d{2}|4[14-9]\\d|5([0-35689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[13589]\\d)\\d{7}$", message="手机号格式不正确")
    private String phoneNumber;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;
    private String role;
    @Min(30)@Max(90)
    private Integer borrowableDays;
    @Min(3)@Max(10)
    private Integer borrowableNumber;
    @Min(0)@Max(10)
    private Integer borrowedNumber;

    public User() {
    }

    public User(Integer id, String username, String password, String phoneNumber, String email, String role, Integer borrowableDays, Integer borrowableNumber, Integer borrowedNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", borrowableDays=" + borrowableDays +
                ", borrowableNumber=" + borrowableNumber +
                ", borrowedNumber=" + borrowedNumber +
                '}';
    }
}
