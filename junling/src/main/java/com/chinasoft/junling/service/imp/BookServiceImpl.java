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
		System.out.println("查询： "+bookDao.queryBooks(books));
		return bookDao.queryBooks(books);
	}

	@Override
	public Integer deleteBooks(String id[]) {
		Integer row=bookDao.deleteBooks(id);
		System.out.println("删除了"+row+"行");
		return row;
	}
	
}
