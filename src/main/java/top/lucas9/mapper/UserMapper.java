package top.lucas9.mapper;

import org.apache.ibatis.annotations.Param;
import top.lucas9.entity.Book;
import top.lucas9.entity.ResetPasswordDto;
import top.lucas9.entity.UpdateUserDto;
import top.lucas9.entity.User;

import java.util.List;

/**
 * @author lucas
 */
public interface UserMapper {
    User selectUserByUserNamePassword(@Param("username") String username, @Param("password") String password);
    void insertUser(@Param("user") User user);
    Integer selectByUsername(@Param("username") String username);
    Integer selectByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    Integer selectByEmail(@Param("email") String email);
    Integer selectToResetPassword(@Param("resetPasswordDto") ResetPasswordDto  resetPasswordDto);
    void updatePassword(@Param("userId") Integer id, @Param("newPassword") String newPassword);
    void updateUser(@Param("user") UpdateUserDto user);
    void deleteUser(@Param("username") String username);
    List<User> selectUserByKeyword(@Param("keyword") String keyword);
    User selectUserByUsername(@Param("username") String username);
    Integer updateUserBorrowBook(@Param("username") String username);
    Integer updateUserReturnBook(@Param("username") String username);
}
