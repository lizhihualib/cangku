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
import com.chinasoft.junling.bean.Users;
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
	private UserHandleService UserHandeleServiceImpl;
	@RequestMapping("/queryCollectBooks")
	@ResponseBody
	public Map queryCollectBooks(HttpServletRequest req,HttpServletResponse resp,String lID) throws IOException{
		List<Books> list = UserHandeleServiceImpl.query(lID);
		Map map=new HashMap<>();
		map.put("rows", list);
		return map;
	}
	 @RequestMapping("/deleteCollectBooks") 
	 @ResponseBody
	public JSONObject deleteCollectBooks(HttpServletRequest req,HttpServletResponse resp,int[] ids,int lID) throws IOException{
		 JSONObject json=new JSONObject();
	     if(UserHandeleServiceImpl.delete(ids,lID)){  
	    	 json.put("status", 1);
			 json.put("tip", "删除成功"); 
	     }
	     else {
	    	 json.put("status", 0);
			 json.put("tip", "删除失败"); 
	     }
		return json;  
	}
	 @RequestMapping("/personalInformation")
	 @ResponseBody
	public Object personalInformation(HttpServletRequest req,HttpServletResponse resp,int lID) throws IOException{
		 
	     Users user = UserHandeleServiceImpl.personalInformation(lID);
	     System.out.println(user.getLogin().getuName());
		return user;  
	}
}
