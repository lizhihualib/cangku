package com.chinasoft.junling.controller;

import java.util.Date;
import java.util.List;

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
import com.chinasoft.junling.util.Date2JsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


@Controller
@RequestMapping("/user")
public class UsersController {
	@Resource
	  private IUsersService userService;
	@RequestMapping(value="/queryUser")
	@ResponseBody
	 public void queryUser(HttpSession session,Users users) throws Exception{
		Login login=(Login)session.getAttribute("login");
		System.out.println(login.getUsers_uId());
		System.out.println("haha");
		users.setuId(login.getUsers_uId());
		Users userinfo=userService.queryUser(users);
		System.out.println(userinfo.getuId());
	
	}
	@RequestMapping(value="/queryUsers")
	@ResponseBody
	 public JSONObject queryUsers(HttpServletResponse resp,HttpSession session,Users users) throws Exception{
		
		List<Users> list=userService.queryUsers(users);
		JsonConfig config=new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new Date2JsonValueProcessor("yyyy-MM-dd"));
		System.out.println("haha");
		JSONObject json=new JSONObject();
		json.put("rows", JSONArray.fromObject(list, config));
		json.put("total",200);
		System.out.println(json.toString());
		return json;
		
	
	}
	@RequestMapping(value="/insertUser")
	 public boolean insertUser(HttpSession session,Users users) throws Exception{
		
		
		return false;  
	
	
	
	}
	@RequestMapping(value="/updatetUser")
	 public boolean updatetUser(HttpSession session,Users users) throws Exception{
		
		
		return false;  
	
	
	
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
