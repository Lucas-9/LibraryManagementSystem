package top.lucas9.entity;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author lucas
 */
public class LoginDto implements Serializable {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码不能为空")
    private String checkCode;

    public LoginDto() {
    }

    public LoginDto(String username, String password, String checkCode) {
        this.username = username;
        this.password = password;
        this.checkCode = checkCode;
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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }
}
