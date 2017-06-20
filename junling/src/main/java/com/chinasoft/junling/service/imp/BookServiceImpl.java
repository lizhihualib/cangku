package com.chinasoft.junling.service.imp;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

	@Override
	public Integer updateBooks(Books books) {
		Integer row=bookDao.updateBooks(books);
		if(row==0){
			System.out.println("修改失败！");
		}else{
			System.out.println("修改了一行！");
		}
		return row;
	}

	

	@Override
	public Integer insertBooks(File dir, HttpServletRequest req) {
		return null;
	}
	
}
