package com.chinasoft.junling.dao;

import java.util.ArrayList;
import java.util.List;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;

public interface UsersDao {
	List<Users> queryAuthors(Users users);
	List<Users> queryReaders(Users users);
	boolean deleteUser(int[] uId);
	boolean updateUser(Users users);
	boolean insertUser(Users users);
	int count(Users users);
	int count1(Users users);
	ArrayList<Books> queryRanking(Books books);
	List<Books> queryRankingtwo(int[] array);
}
