package com.chinasoft.junling.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.service.UserHandleService;
import com.chinasoft.junling.service.imp.UserHandeleServiceImpl;
import com.chinasoft.junling.util.Date2JsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



@Controller
@RequestMapping("/UserHandle")
public class UserHandle {
	@Resource
	private UserHandleService userHandleInterface;
	@RequestMapping("/queryCollectBooks")
	@ResponseBody
	public Map queryCollectBooks(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		List<Books> list = userHandleInterface.query();
		Map map=new HashMap<>();
		map.put("rows", list);
		return map;
	}

}
