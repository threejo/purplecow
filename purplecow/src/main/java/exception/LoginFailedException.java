package exception;

import com.purplecow.security.ErrorCode;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginFailedException extends RuntimeException {

    public LoginFailedException(){    	
        super(ErrorCode.LOGIN_FAILED.getMessage());
        log.info(ErrorCode.LOGIN_FAILED.getMessage());
    }

    private LoginFailedException(String msg){
        super(msg);
    }
}