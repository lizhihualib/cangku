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
	private IBookService bookservice;
	
	
	@RequestMapping(value="/querybooks") 
	public Books querybooks(HttpSession session,Books books){
		Books book=bookservice.queryBooks(books);
		return book;
	}
}
