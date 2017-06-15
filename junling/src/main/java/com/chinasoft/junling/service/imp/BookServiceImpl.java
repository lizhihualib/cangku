package com.chinasoft.junling.service.imp;

import javax.annotation.Resource;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.dao.IBookDao;
import com.chinasoft.junling.service.IBookService;

public class BookServiceImpl implements IBookService{
	@Resource
	private IBookDao bookDao;
	
	@Override
	public Books queryBooks(Books books) {
		Books book=bookDao.queryBooks(books);
		return book;
	}
	
}
