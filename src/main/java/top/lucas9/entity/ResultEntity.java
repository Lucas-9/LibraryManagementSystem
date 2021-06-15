package top.lucas9.entity;
import java.io.Serializable;

/**
 * @author lucas
 */
public class ResultEntity<T> implements Serializable{

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MESSAGE = "NO_MESSAGE";
    public static final String NO_DATA = "NO_DATA";

    private String status;
    private String message;
    private T data;

    public static ResultEntity<String> success() {
        return new ResultEntity<String>(SUCCESS, NO_MESSAGE, NO_DATA);
    }

    public static ResultEntity<String> success(String message) {
        return new ResultEntity<String>(SUCCESS, message, NO_DATA);
    }

    public static<E> ResultEntity<E> success(String message, E data) {
        return new ResultEntity<E>(SUCCESS, message, data);
    }

    public static<E> ResultEntity<E> success(E data) {
        return new ResultEntity<E>(SUCCESS, NO_MESSAGE, data);
    }


    public static ResultEntity<String> failed() {
        return new ResultEntity<String>(FAILED, NO_MESSAGE, NO_DATA);
    }

    public static ResultEntity<String> failed(String message) {
        return new ResultEntity<String>(FAILED, message, NO_DATA);
    }

    public static<E> ResultEntity<E> failed(String message, E data) {
        return new ResultEntity<E>(FAILED, message, data);
    }

    public static<E> ResultEntity<E> failed(E data) {
        return new ResultEntity<E>(FAILED, NO_MESSAGE, data);
    }



    public ResultEntity() {

    }

    public ResultEntity(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getFAILED() {
        return FAILED;
    }

    public static String getNoMessage() {
        return NO_MESSAGE;
    }

    public static String getNoData() {
        return NO_DATA;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
