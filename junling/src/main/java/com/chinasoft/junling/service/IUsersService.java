package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Users;

public interface IUsersService {
	List<Users> queryAuthors(Users users);
	List<Users> queryReaders(Users users);
	boolean insertUser(Users users);
	boolean deleteUser(String uId);
	boolean updateUser(Users users);
}
