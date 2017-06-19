package com.chinasoft.junling.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;
import com.chinasoft.junling.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookControl {

	@Resource
	private IBookService bookService;

	
	
	@RequestMapping(value="/querybooks") 
	@ResponseBody
	public Map querybooks(HttpSession session,Books books){
		Map map=new HashMap<String,Object>();
		List<Books> rows=bookService.queryBooks(books);
		map.put("rows", rows);
		return map;
	}
}
