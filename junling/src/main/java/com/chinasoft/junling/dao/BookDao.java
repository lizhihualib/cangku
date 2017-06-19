package com.chinasoft.junling.dao;


import java.util.List;

import com.chinasoft.junling.bean.Books;

public interface BookDao {
	List<Books> queryBooks(Books books);
}
