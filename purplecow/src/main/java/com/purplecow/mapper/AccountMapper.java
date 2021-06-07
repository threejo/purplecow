package com.purplecow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Account;

@Mapper
public interface AccountMapper {

	public List<Account> getAll() throws Exception;
	public Account getOne() throws Exception;

	public void insertAccount(Account account) throws Exception;

}
