package com.chinasoft.junling.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasoft.junling.bean.Login;
import com.chinasoft.junling.service.ILoginService;
import com.chinasoft.junling.service.imp.LoginServiceImp;

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
  * @param username 
  *   用户名 
  * @param password 
  *   密码 
  * @return 
  */
 @RequestMapping(value="/login") 
 public String login(HttpSession session,Login login) throws Exception{  

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
   
   
   
} 