package com.purplecow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public void insertUsers(@RequestBody Users users) {



		usersService.insertUser(users);

	}


	/*id로 유저조회하기*/
	@GetMapping("/users/{id}")
	public Users getUser(@PathVariable("id") int id) {
		return usersService.getUser(id);
	}

}
