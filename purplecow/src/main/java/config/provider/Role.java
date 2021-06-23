package config.provider;

import lombok.Getter;
import java.util.Arrays;

//권한은 관리자-사용자-알 수 없음으로 나눠진다
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN", "관리자권한"),
    USER("ROLE_USER", "사용자권한"),
    UNKNOWN("UNKNOWN", "알수없는 권한");

    private String code;
    private String description;

    Role(String code, String description) {
        this.code = code;
        this.description = description;
    }
    //들어온 파라미터에 정해진 권한 중에 있으면 그 권한 객체를 반환하지만
    //없다면 unknown을 반환한다.
    public static Role of(String code) {
        return Arrays.stream(Role.values())
                .filter(r -> r.getCode().equals(code))
                .findAny()
                .orElse(UNKNOWN);
    }
}