package com.chinasoft.junling.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.SynthesizedAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.junling.bean.Login;
import com.chinasoft.junling.service.ILoginService;

import net.sf.json.JSONObject;



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
 @ResponseBody
 public JSONObject login(HttpSession session,Login login) throws Exception{  
	 
  System.out.println(login.toString());
  
    int idCount=loginService.idCount(login);
       JSONObject json=new JSONObject();
      if(idCount>0){ 
          Login loginBean= loginService.queryLogin(login);
          //在Session里保存信息 
         
    	  session.setAttribute("loginBean", loginBean);
    	  session.setAttribute("lId", loginBean.getlID());
          session.setAttribute("uType",loginBean.getuType());
          System.out.println(loginBean.getlID());
     	    json.put("status", 1);
    	    json.put("tip", "登陆成功"); 
     }else{  
    	    json.put("status", 0);
    	    json.put("tip", "账号或密码错误");
        }  
     return json; 
        

 } 
 /** 
  * to主页
  * @param session 
  *   HttpSession 
  * @return 
  */
 @RequestMapping(value="/toCenter") 
 public String toCenter(HttpSession session,Login login) {  
	    String uType=  (String) session.getAttribute("uType");
	      System.out.println("==="+uType);
     return "view/center"; 
        

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
    
  return "view/login"; 
 } 
 /**  
  * 获取所有用户列表  
  * @param request  
  * @return  
 * @throws IOException 
  */  
 @RequestMapping("/getAllLogins") 
 @ResponseBody
 public Map getAllUser(Login querylogin) throws IOException{  
      System.out.println(querylogin.getCurPage());
      System.out.println("Star="+querylogin.getStar());
         System.out.println("page="+querylogin.getPageSize());
	 List<Login> logins = loginService.findAll(querylogin); 
       for (Login login : logins) {
		System.out.println(login.toString());
	}
      String total= loginService.total(querylogin);
	 Map map=new HashMap<String,Object>();
		map.put("rows", logins);
	    map.put("total", total);
     return map;  
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
	int countByName= loginService.findByName(login);

	 JSONObject json=new JSONObject();
	 if(countByName>0){
		 json.put("status",3);
		 json.put("tip", "该用户已存在");
		 return json;
       }
	 
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
	 System.out.println(login);
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
  * 删除用户  
  * @param id  
  * @param request  
  * @param response  
  */  
 @RequestMapping("/deleteLogin") 
 @ResponseBody
 public JSONObject deleteLogin(int[] ids){  
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