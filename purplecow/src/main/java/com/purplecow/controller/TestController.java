package com.purplecow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.purplecow.mapper.AccountMapper;

@Controller
public class TestController {

	@Autowired
    private AccountMapper accountMapper;



	@RequestMapping("home/index")
	public String index(Model model) throws Exception {

		model.addAttribute("message", "좋은 아침입니다");
		model.addAttribute("now", new Date());
		model.addAttribute("account",accountMapper.getOne());


		return "home/index";
	}
}
