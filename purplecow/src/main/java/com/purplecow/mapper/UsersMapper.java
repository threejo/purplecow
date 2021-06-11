package com.purplecow.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Users;

@Mapper
public interface UsersMapper {

	void insertUser(Users user);

	Users getUser(int id);

}
