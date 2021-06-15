package top.lucas9.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.lucas9.entity.ResultEntity;

import java.io.IOException;

/**
 * @author lucas
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 捕获参数校验失败异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity handler(MethodArgumentNotValidException e) {
        return ResultEntity.failed(e.getBindingResult().getFieldError().getDefaultMessage());
    }
    /**
     * 处理 Assert 校验失败异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultEntity handler(IllegalArgumentException e) throws IOException {
        return ResultEntity.failed(e.getMessage());
    }

    /**
     * 处理 权限认证失败异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationException.class)
    public ResultEntity handler(AuthenticationException e) {
        return ResultEntity.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResultEntity handler(Exception e){
        return ResultEntity.failed(e.getMessage());
    }
}
