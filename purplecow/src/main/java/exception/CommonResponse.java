package exception;

import lombok.Builder;
import lombok.Getter;
 
@Getter
@Builder
//응답으로 받을 수 있는 데이터를 빌더패턴으로 저장
public class CommonResponse {

    private String message;
    private int status;
    private String code;

}
