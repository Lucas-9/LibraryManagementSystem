package top.lucas9.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.lucas9.entity.*;
import top.lucas9.exception.AuthenticationException;
import top.lucas9.mapper.UserMapper;
import top.lucas9.service.UserService;
import top.lucas9.utils.AuthenticateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lucas
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultEntity login(LoginDto loginDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String checkCode = session.getAttribute("CHECK_CODE").toString();
        if (null == checkCode || !checkCode.equalsIgnoreCase(loginDto.getCheckCode())) {
            return ResultEntity.failed("验证码错误");
        }
        User user = userMapper.selectUserByUserNamePassword(loginDto.getUsername(), loginDto.getPassword());
        Assert.notNull(user, "用户名或密码错误");
        String role = user.getRole();
        session.setAttribute("ROLE", role);
        session.setAttribute("USER_NAME", user.getUsername());
        return ResultEntity.success("登录成功", user);
    }

    /**
     * 通用注册接口
     * 无超级管理员权限，则将默认信息设置进去，避免前端非超级管理员将默认信息设置成功
     * @param user
     * @param request
     */
    @Override
    public void register(User user, HttpServletRequest request) {
        Integer userId = userMapper.selectByUsername(user.getUsername());
        Assert.isNull(userId, "用户名已存在");
        userId =  userMapper.selectByPhoneNumber(user.getPhoneNumber());
        Assert.isNull(userId, "手机号已被绑定");
        userId =  userMapper.selectByEmail(user.getEmail());
        Assert.isNull(userId, "邮箱已被绑定");
        boolean isSuperAdmin = AuthenticateUtil.isSuperAdmin(request);
        if (!isSuperAdmin) {
            user.setRole("USER");
            user.setBorrowableDays(30);
            user.setBorrowableNumber(3);
            user.setBorrowedNumber(0);
        }
        userMapper.insertUser(user);
    }

    @Override
    public void resetPassword(ResetPasswordDto resetPasswordDto) {
        Integer id = userMapper.selectToResetPassword(resetPasswordDto);
        Assert.notNull(id, "信息不匹配");
        userMapper.updatePassword(id, resetPasswordDto.getNewPassword());
    }

    @Override
    public void updateUser(UpdateUserDto user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }

    @Override
    public PageInfo<User> selectUserByKeyword(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectUserByKeyword(keyword);
        return new PageInfo<>(users);
    }
}
