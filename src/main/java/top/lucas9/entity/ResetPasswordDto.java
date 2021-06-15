package top.lucas9.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lucas
 */
public class ResetPasswordDto implements Serializable {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp="^1(3\\d{2}|4[14-9]\\d|5([0-35689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[13589]\\d)\\d{7}$", message="手机号格式不正确")
    private String phoneNumber;
    @NotBlank(message = "原始密码不能为空")
    private String originalPassword;
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    public ResetPasswordDto() {
    }

    public ResetPasswordDto(String username, String email, String phoneNumber, String originalPassword, String newPassword) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.originalPassword = originalPassword;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ResetPasswordDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", originalPassword='" + originalPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
