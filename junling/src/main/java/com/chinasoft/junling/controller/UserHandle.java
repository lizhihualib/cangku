package com.chinasoft.junling.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.service.UserHandleService;
import com.chinasoft.junling.service.imp.UserHandeleServiceImpl;


import net.sf.json.JsonConfig;



@Controller
@RequestMapping("/UserHandle")
public class UserHandle {
	@RequestMapping("/queryCollectBooks")
	public void queryCollectBooks(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		UserHandleService userHandleService=new UserHandeleServiceImpl();
		List<Books> list = userHandleService.query();
		JsonConfig config=new JsonConfig();
		
	}

}
