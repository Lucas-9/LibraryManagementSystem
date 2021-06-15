package top.lucas9.service;

import com.github.pagehelper.PageInfo;
import top.lucas9.entity.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lucas
 */
public interface UserService {
    ResultEntity login(LoginDto loginDto, HttpServletRequest request);
    void register(User user, HttpServletRequest request);
    void resetPassword(ResetPasswordDto resetPasswordDto);
    void updateUser(UpdateUserDto user);
    void deleteUser(String username);
    PageInfo<User> selectUserByKeyword(Integer pageNum, Integer pageSize, String keyword);
}
