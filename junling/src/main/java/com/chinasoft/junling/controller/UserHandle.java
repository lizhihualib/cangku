package com.chinasoft.junling.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		return user;  
	}
	 
	 
	 @RequestMapping("/updateInformation")
	 @ResponseBody
	public Object updateInformation(HttpServletRequest req,HttpServletResponse resp,Users user) throws IOException{
		 System.out.println(user.toString());
	     int falg = UserHandeleServiceImpl.updateInformation(user);
	     
		return falg;  
	}
	 
	 
	 @RequestMapping("/updateSignIn")
	 @ResponseBody
	public Object updateSignIn(HttpServletRequest req,HttpServletResponse resp,int id) throws IOException{
			System.out.println(id);
		 	Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String timeNow=format.format(date);
			System.out.println(timeNow);
			Users user = UserHandeleServiceImpl.querySignIn(id);
			
			String timeOld=user.getuSignState();
			System.out.println(timeOld);
			String birthday=user.getuBirthday();
			String happy="";
			if(timeNow.equals(timeOld)){
				happy="小主，您今天已经签到，明天再来吧。。。";
				JSONObject obj1=new JSONObject();
				obj1.put("tip", happy);
				obj1.put("result", 0);
				return obj1;
			}else{
				int val = (int)(Math.random()*20+1);
				String[] timeNow1=timeNow.split("-");
				
				if(timeNow.equals(birthday)){
					val=val*3;
					happy="今天是你的生日，赠送阅豆已翻3倍,获得"+val+"个阅豆!!!";
					};
				if(timeNow1[2].equals("07")){
					val=val*2;
					happy="今天是'阅起节'（每月7号），赠送阅豆已翻2倍,获得"+val+"个阅豆!!!";
					};
				if(timeNow1[2].equals("07")&&timeNow.equals(birthday)){
					happy="今天即是'阅起节'，又是你的生日，赠送阅豆已翻6倍,获得"+val+"个阅豆!!!";
					};
				if((!timeNow1[2].equals("07"))&&(!timeNow.equals(birthday)))happy="获得"+val+"个阅豆!!!";
				int updateSignStateResult = UserHandeleServiceImpl.updateSignState(id,timeNow,val);
				JSONObject obj2=new JSONObject();
				obj2.put("tip", happy);
				obj2.put("result", updateSignStateResult);
				return obj2;
			}
			  
	}

}
