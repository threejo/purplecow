package com.purplecow.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Users;

@Mapper
public interface UsersMapper {

	void insertUser(Users user);

	Users getUser(int id);
	
	void updatePasswordInUsers(int id, String password);
	void updateEmailInUsers(int id, String email);
	void updatePhoneNoInUsers(int id, String phone);
	
	void deleteUserById(int id);

	Optional<Users> getUsersByEmail(String email);

	

	

	

}
