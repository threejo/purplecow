<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<body>
    <c:if test="${userId eq null}">
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=93f0f6f4970c0e42fd6386051d315ea3&redirect_uri=http://localhost:8088/kakaologin&response_type=code">
            <img src="/img/kakao_account_login_btn_medium_wide_ov.png">
        </a>
    </c:if>
    <c:if test="${userId ne null}">
        <h1>로그인 성공입니다</h1>
        <input type="button" value="로그아웃" onclick="location.href='/logout'">
    </c:if>
</body>