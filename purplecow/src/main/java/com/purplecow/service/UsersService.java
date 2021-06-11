package com.purplecow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Users;
import com.purplecow.mapper.UsersMapper;

@Service
public class UsersService {
	
	@Autowired UsersMapper userMapper;

	public void insertUser(Users user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
	}

}
