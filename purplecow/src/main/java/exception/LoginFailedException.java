package exception;

public class LoginFailedException extends RuntimeException {

    public LoginFailedException(){
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }

    private LoginFailedException(String msg){
        super(msg);
    }
}
