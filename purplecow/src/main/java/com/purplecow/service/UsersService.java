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
	
	public void updatePasswordInUsers(int id, String password) {
		usersMapper.updatePasswordInUsers(id,password);
	}
	public void updateEmailInUsers(int id, String email) {
		usersMapper.updateEmailInUsers(id,email);
	}
	public void updatePhoneNoInUsers(int id, String phone) {
		usersMapper.updatePhoneNoInUsers(id,phone);
	}
	
	public void deleteUserById(int id) {
		usersMapper.deleteUserById(id);
	}
	public Users getUserByEmail(String email) {
		return usersMapper.getUserByEmail(email);
	}
	
	

	

}
