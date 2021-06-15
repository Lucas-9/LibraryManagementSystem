package top.lucas9.exception;

/**
 * @author lucas
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(){
        super();
    }

    public AuthenticationException(String message){
        super(message);
    }
}
