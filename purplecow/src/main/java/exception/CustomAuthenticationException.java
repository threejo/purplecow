package exception;

public class CustomAuthenticationException extends RuntimeException {

    //따로 들어오는 exception이 없다면 인증실패 메세지 전달
	

	public CustomAuthenticationException(){
        super(ErrorCode.AUTHENTICATION_FAILED.getMessage());
    }

    public CustomAuthenticationException(Exception ex){
        super(ex);
    }
}