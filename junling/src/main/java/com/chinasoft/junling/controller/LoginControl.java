package com.chinasoft.junling.controller;

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.SynthesizedAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.junling.bean.Login;
import com.chinasoft.junling.service.ILoginService;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/** 
 * 登录认证的控制器 
 */
@Controller
@RequestMapping("/login")
public class LoginControl { 
	@Resource
  private ILoginService loginService;
 /** 
  * 登录 
  * @param session 
  *   HttpSession 
  * @return 
  */
 @RequestMapping(value="/login") 
 public String login(HttpSession session,Login login) throws Exception{  
	 System.out.println("lalalalalal");
  System.out.println(login.toString());
  
       Login loginBean= loginService.queryLogin(login);
       //在Session里保存信息 

       session.setAttribute("login", loginBean);
       System.out.println(loginBean.getlID());
      if(loginBean.getlID()!=0){ 
      //重定向 
    	  return "view/center"; 
    	  }else
     return "view/main"; 
        
 } 
   
 /** 
  * 退出系统 
  * @param session 
  *   Session 
  * @return 
  * @throws Exception 
  */
 @RequestMapping(value="/logout") 
 public String logout(HttpSession session) throws Exception{ 
  //清除Session 
  session.invalidate(); 
    
  return "view/main"; 
 } 
 /**  
  * 获取所有用户列表  
  * @param request  
  * @return  
 * @throws IOException 
  */  
 @RequestMapping("/getAllLogins") 
 @ResponseBody
 public JSONObject getAllUser(String uType) throws IOException{  
      System.out.println(uType);
	 List<Login> logins = loginService.findAll(uType); 
       for (Login login : logins) {
		System.out.println(login.toString());
	}
		JsonConfig config=new JsonConfig();
			
		JSONObject json=new JSONObject();
		json.put("rows", JSONArray.fromObject(logins, config));
		System.out.println(json.toString());
	
     return json;  
 }  

 /**  
  * 添加用户 
  * @param login  
  * @param request  
  * @return  
  */  
 @RequestMapping("/insertLogin") 
 @ResponseBody
 public JSONObject insertLogin(Login login){  
	 JSONObject json=new JSONObject();
	 System.out.println("++++++++");
	 System.out.println("添加"+login.toString());
    if( loginService.insertLogin(login)){
   	    json.put("status", 1);
	    json.put("tip", "添加成功"); 
 }else{  
	 json.put("status", 0);
	 json.put("tip", "添加失败");
    }  
     return json;  
 }  
 /**  
  *修改用户  
  * @param user  
  * @param request  
  * @return  
  */  
 @RequestMapping("/updateLogin") 
 @ResponseBody
 public  JSONObject updateLogin(Login login){ 
	 JSONObject json=new JSONObject();
     if(loginService.updateLogin(login)){    
          
    	 json.put("status", 1);
		 json.put("tip", "修改成功"); 
     }else{  
    	 json.put("status", 0);
		 json.put("tip", "修改失败"); 
     } 
     return json;
 }  
 /**  
  * 根据id查询单个用户  
  * @param id  
  * @param request  
  * @return  
  */  
 @RequestMapping("/getLogin")  
 public String getUser(int id,HttpServletRequest request,Model model){  
     request.setAttribute("login", loginService.findById(id));  
     model.addAttribute("login", loginService.findById(id));  
     return "/editLogin";  
 }  
 /**  
  * 删除用户  
  * @param id  
  * @param request  
  * @param response  
  */  
 @RequestMapping("/deleteLogin") 
 @ResponseBody
 public JSONObject deleteLogin(String ids){  
	 JSONObject json=new JSONObject();
	 System.out.println(ids);
     if(loginService.deleteLogin(ids)){  
    	 json.put("status", 1);
		 json.put("tip", "删除成功"); 
     }
     else {
    	 json.put("status", 0);
		 json.put("tip", "删除失败"); 
     }
	return json;  
      
   
 }  
   
   
} 