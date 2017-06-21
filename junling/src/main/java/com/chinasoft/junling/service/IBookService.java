package com.chinasoft.junling.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.chinasoft.junling.bean.Books;

public interface IBookService {
	List<Books> queryBooks(Books books);
	Integer deleteBooks(String id[]);
	Integer updateBooks(Books books);
	Integer insertBooks(Books books);
	Integer queryUid(int lId);
}
