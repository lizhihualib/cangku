package com.chinasoft.junling.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Login;
import com.chinasoft.junling.bean.MyComparator;
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
	 public Map queryAuthors(Users users) throws Exception{
		Map map=new HashMap<String,Object>();
		List<Users> rows=userService.queryAuthors(users);
		int count=userService.count(users);
		map.put("total",count);
		map.put("rows", rows);
		return map;
	
	}
	@RequestMapping(value="/queryReaders")
	@ResponseBody
	 public Map queryReaders(HttpServletResponse resp,HttpSession session,Users users) throws Exception{
		Map map=new HashMap<String,Object>();
		List<Users> rows=userService.queryReaders(users);
		int count1=userService.count(users);
		map.put("total",count1);
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
	@ResponseBody
	 public void deleteUser(HttpServletResponse resp,int[] uId) throws Exception{
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
	@RequestMapping(value="/queryRanking")
	@ResponseBody
	public List queryRanking(Books books){
		int num=0;
		int[] array=new int [10];
		List<Books> list=userService.queryRanking(books);
		 Collections.sort(list, new MyComparator());
		 Iterator<Books> it=list.iterator();
		 while(it.hasNext()){
			 array[num]=it.next().getbId();
			 ++num;
			 if(num>9)
				 break;
		 }
		List<Books> list1=userService.queryRankingtwo(array);
		Collections.sort(list1, new MyComparator());
		
		return list1;
	}
	
}
