package com.purplecow.controller;

import java.util.Date;
import java.util.Map;

import javax.websocket.Encoder.Text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Users;
import com.purplecow.service.UsersService;

@RestController
public class APIUsersController {

	@Autowired UsersService usersService;
	

	/*POST*/
	/*유저 생성하기 */
	@ResponseBody
	@PostMapping(value = "/users")
	public void insertUsers(@RequestBody Users users) {

		usersService.insertUser(users);

	} 

	

//	/*SELECT*/
//	/*id로 유저조회하기*/
//	@GetMapping("/users/{id}")
//	public Users getUser(@PathVariable("id") int id) {
//		return usersService.getUser(id);
//	}
//	

	@GetMapping("/users/{email}")
	public Users getUserByEmail(@PathVariable ("email") String email) { 
		System.out.println(email);
		return usersService.getUserByEmail(email);
	}
	
	
	/*PUT*/	
	/*유저 정보 업데이트*/
	@ResponseBody
	@PutMapping("/users/{id}")
	public void updateUsersById(@PathVariable("id") int id,@RequestBody(required= false) Map<String,Object> rbo) {
		if(rbo.get("password") != null) usersService.updatePasswordInUsers(id,(String)rbo.get("password"));
		if(rbo.get("email") != null) usersService.updateEmailInUsers(id,(String)rbo.get("email"));
		if(rbo.get("phone") != null) usersService.updatePhoneNoInUsers(id,(String)rbo.get("phone"));
	}

	/*DELETE*/
	/*유저 삭제하기 */
	@DeleteMapping("/users")
	public void deleteUserById(@RequestParam int id) {
		usersService.deleteUserById(id);
	}
}
