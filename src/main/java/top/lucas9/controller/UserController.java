package top.lucas9.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.lucas9.entity.*;
import top.lucas9.service.UserService;
import top.lucas9.utils.AuthenticateUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lucas
 */
@RestController
@RequestMapping("/do")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ResultEntity login(@Validated @RequestBody LoginDto loginDto, HttpServletRequest request) {
        return userService.login(loginDto, request);
    }

    @RequestMapping("/register")
    public ResultEntity register(@Validated @RequestBody User user, HttpServletRequest request) {
        userService.register(user, request);
        return ResultEntity.success("注册成功");
    }

    @RequestMapping("/resetPassword")
    public ResultEntity resetPassword(@Validated @RequestBody ResetPasswordDto resetPasswordDto) {
        userService.resetPassword(resetPasswordDto);
        return ResultEntity.success("重置密码成功");
    }

    @RequestMapping("/deleteUser")
    public ResultEntity deleteUser(String username,HttpServletRequest request) {
        AuthenticateUtil.hasRole(request, "SUPER_ADMIN");
        userService.deleteUser(username);
        return ResultEntity.success("删除成功");
    }

    @RequestMapping("/updateUser")
    public ResultEntity updateUser(@RequestBody UpdateUserDto user, HttpServletRequest request) {
        AuthenticateUtil.hasRole(request ,"SUPER_ADMIN");
        userService.updateUser(user);
        return ResultEntity.success("修改成功");
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request) {
        AuthenticateUtil.logout(request);
    }

    @RequestMapping("/selectUserByKeyword")
    public ResultEntity<PageInfo<User>> selectUserByKeyword(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        return ResultEntity.success("查询成功", userService.selectUserByKeyword(pageNum, pageSize, keyword));
    }
}
