package com.purplecow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Users;
import com.purplecow.mapper.UsersMapper;

@Service
public class UsersService {

	@Autowired UsersMapper usersMapper;

	public void insertUser(Users user) {

		usersMapper.insertUser(user);
	}

	public Users getUser(int id) {

		return usersMapper.getUser(id);
	}

	public void deleteUserById(int id) {

		usersMapper.deleteUserById(id);

	}

}
