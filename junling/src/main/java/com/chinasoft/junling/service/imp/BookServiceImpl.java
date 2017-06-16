package com.chinasoft.junling.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.dao.BookDao;
import com.chinasoft.junling.service.IBookService;

@Service("bookservice")

public class BookServiceImpl implements IBookService{
	@Resource
	private BookDao bookDao;
	
	@Override
	public Books queryBooks(Books books) {
		Books book=bookDao.queryBooks(books);
		return book;
	}
	
}
