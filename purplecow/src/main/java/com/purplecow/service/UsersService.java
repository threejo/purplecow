package com.purplecow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Users;
import com.purplecow.mapper.UsersMapper;

@Service
public class UsersService {

	@Autowired UsersMapper usersMapper;

	public void insertUser(Users user) {
		// TODO Auto-generated method stub
		usersMapper.insertUser(user);
	}

	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return usersMapper.getUser(id);
	}

}
