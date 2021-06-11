package com.purplecow.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Users;
import com.purplecow.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired UsersService usersService;
	
	/*유저생성하기 */
	
	@ResponseBody
	@PostMapping("/users")
	public void addUser(@RequestBody String email,String password) {
		
		Users users = new Users(email,password);
		
		usersService.insertUser(users);
		
	}
	
	
	/*유저조회하기*/

}
