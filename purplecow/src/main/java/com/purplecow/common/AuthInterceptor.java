package com.purplecow.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		
		if(loginVO == null || !loginVO.isValidUser()) {
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('세션이 만료되어 로그아웃 되었습니다. 다시 로그인 해주세요.'); window.location.href='/login';</script>");
			out.flush();
			
			return false;
		}
		
		return true;
	}

}
