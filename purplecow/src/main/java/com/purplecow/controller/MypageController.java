package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	
	//마이페이지
	@GetMapping("/mypage")
	public String showInfo() {

		return "mypage/mypage";

	}

	//계정 관리(회원 정보 확인 가능)
	@GetMapping("/accountMgt")
	public String showuserInfo() {

		return "/mypage/accountMgt";
		
	}
	
	//회원 정보 수정 전 비밀번호 확인 - 모달
	
	//회원 정보 수정
	@GetMapping("/modifyInfo")
	public String modifyUserInfo() {
		
		return "mypage/modifyInfo";
	}
	
	
	//결제 정보 확인
	@GetMapping("/payInfo")
	public String showPayInfo() {
		
		return "mypage/payInfo";
	}
	
	
	//예약 내역 확인
	@GetMapping("/resvHistory")
	public String showResvHistory() {
		
		return "/mypage/resvHistory";
	}



}
