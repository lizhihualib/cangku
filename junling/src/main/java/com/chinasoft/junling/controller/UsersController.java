package com.chinasoft.junling.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.junling.bean.Login;
import com.chinasoft.junling.bean.Users;
import com.chinasoft.junling.service.IUsersService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/user")
public class UsersController {
	@Resource
	  private IUsersService userService;
	@RequestMapping(value="/queryAuthors")
	@ResponseBody
	 public Map queryAuthors(HttpServletResponse resp,HttpSession session,Users users) throws Exception{
		Map map=new HashMap<String,Object>();
		List<Users> rows=userService.queryAuthors(users);
		map.put("total",200);
		map.put("rows", rows);
		return map;
	
	}
	@RequestMapping(value="/queryReaders")
	@ResponseBody
	 public Map queryReaders(HttpServletResponse resp,HttpSession session,Users users) throws Exception{
		Map map=new HashMap<String,Object>();
		List<Users> rows=userService.queryReaders(users);
		map.put("total",200);
		map.put("rows", rows);
		return map;
	
	}
	@RequestMapping(value="/insertUser",produces="application/json;charset=utf-8")
	 public void insertUser(HttpServletResponse resp,Users users) throws Exception{
		
		boolean flag=userService.insertUser(users);
		JSONObject json=new JSONObject();
		if(flag){
			json.put("status", 1);
			json.put("tip", "添加成功");
		}else{
			json.put("status", 0);
			json.put("tip", "添加失败");
		}
		resp.getWriter().println(json);  
	
	
	
	}
	@RequestMapping(value="/updateUser")
	 public void updateUser(HttpServletResponse resp,Users users) throws Exception{
		boolean flag=userService.updateUser(users);
		System.out.println(users);
		JSONObject json=new JSONObject();
		if(flag){
			json.put("status", 1);
			json.put("tip", "修改成功");
		}else{
			json.put("status", 0);
			json.put("tip", "修改失败");
		}
		resp.getWriter().println(json);  
	
	
	
	}
	@RequestMapping(value="/deleteUser")
	 public void deleteUser(HttpServletRequest req, HttpServletResponse resp,Users users) throws Exception{
		String uId=req.getParameter("uId");
		System.out.println(uId);
		boolean flag=userService.deleteUser(uId);
		JSONObject json=new JSONObject();
		if(flag){
			json.put("status", 1);
			json.put("tip", "删除成功");
		}else{
			json.put("status", 0);
			json.put("tip", "删除失败");
		}
		resp.getWriter().println(json);
	
	}
	
}
