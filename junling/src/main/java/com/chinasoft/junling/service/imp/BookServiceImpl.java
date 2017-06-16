package com.chinasoft.junling.service.imp;

import java.util.List;

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
	public List<Books> queryBooks(Books books) {
		return bookDao.queryBooks(books);
	}
	
}
