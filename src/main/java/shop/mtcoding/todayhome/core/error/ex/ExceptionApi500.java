package shop.mtcoding.todayhome.core.error.ex;

// 인증관련
public class ExceptionApi500 extends RuntimeException {
    public ExceptionApi500(String message) {
        super(message);
    }
}
