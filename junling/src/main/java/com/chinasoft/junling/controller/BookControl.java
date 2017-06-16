package com.chinasoft.junling.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookControl {

	@Resource	
	private IBookService bookService;

	
	
	@RequestMapping(value="/querybooks") 
	public Books querybooks(HttpSession session,Books books){
		Books book=bookService.queryBooks(books);
		System.out.println(book.toString());
		return null;
	}
}
