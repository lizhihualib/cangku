package com.chinasoft.junling.dao;

import java.util.List;

import com.chinasoft.junling.bean.Users;

public interface UsersDao {
	List<Users> queryAuthors(Users users);
	List<Users> queryReaders(Users users);
	boolean deleteUser(String uId);
	boolean updateUser(Users users);
	boolean insertUser(Users users);
}
