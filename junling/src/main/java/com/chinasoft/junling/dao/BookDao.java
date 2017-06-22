package com.chinasoft.junling.dao;


import java.util.List;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;

public interface BookDao {
	List<Books> queryBooks(Books books);
	Integer countTotal(Books books);
	Integer deleteBooks(String id[]);
	Integer updateBooks(Books books);
	Integer insertBooks(Books books);
	Users queryUid(int lId);
}
