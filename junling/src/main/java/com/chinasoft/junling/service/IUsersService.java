package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Users;

public interface IUsersService {
	List<Users> queryUsers(Users users);
	Users queryUser(Users users);
	boolean insertUser(Users users);
	boolean deleteUser(String uId);
	boolean updateUser(Users users);
}
