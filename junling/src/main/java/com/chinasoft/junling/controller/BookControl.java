package com.chinasoft.junling.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;
import com.chinasoft.junling.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookControl {

	@Resource
	private IBookService bookService;

	
	
	@RequestMapping(value="/querybooks") 
	@ResponseBody
	public Map queryBooks(Books books){
		Map map=new HashMap<String,Object>();
		List<Books> rows=bookService.queryBooks(books);
		int total=bookService.countTotal(books);
		map.put("total", total);
		map.put("rows", rows);
		return map;
	}
	
	
	@RequestMapping(value="/deletebooks")
	@ResponseBody
	public Integer deleteBooks(String[] ids){
		System.out.println(Arrays.toString(ids));
		Integer row=bookService.deleteBooks(ids);
		return row;
	}
	
	
	@RequestMapping(value="/updatebooks")
	@ResponseBody
	public Integer updateBooks(Books books){
		System.out.println("接收到的数据： "+books.toString());
		Integer row=bookService.updateBooks(books);
		return row;
	}
	
	
	@RequestMapping(value="/insertbooks",method=RequestMethod.POST)
	
	public String insertBooks(MultipartFile file,HttpServletRequest req) throws IOException{
		Books books=new Books();
		Users user=new Users();
		//获取登陆的ID
		int lId=(Integer)req.getSession().getAttribute("lId");
		//设置上传文件的保存位置
		String path="E:\\books";
	    /*测试文本
	     * if(!file.isEmpty()){  
        //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹  
        System.out.println("================="+file.getName()+" 长度="+ file.getSize());  
            }  */
		String fileName = file.getOriginalFilename(); 
		//测试是否拿到文件名
        //System.out.println("fileName="+fileName);
        File dir = new File(path,fileName);
        //测试是否拿到文件
        //System.out.println("指定路径="+dir);
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        //MultipartFile自带的解析方法  
        file.transferTo(dir);
        
        int uId=bookService.queryUid(lId);
        //测试是否拿到登陆者的uId
        System.out.println(uId);
        books.setbName(req.getParameter("bName"));
        user.setuPenName(req.getParameter("uPenName"));
        books.setUsers(user);
		books.setbType(req.getParameter("bType"));
		books.setbState(req.getParameter("bState")); 
		books.setbIntro(req.getParameter("bIntro"));
		//books.setbClicks(Integer.valueOf(req.getParameter("bClicks"))); 
		//books.setbDownloads(Integer.valueOf(req.getParameter("bDownloads"))); 
		books.setbClicks(0);
		books.setbDownloads(0);
		
		books.setbEdittime(req.getParameter("bEdittime"));
		books.setbOverTime(req.getParameter("bOverTime"));
		books.setUsers_uId(uId);
        books.setAddr(String.valueOf(dir));
  
        Integer row=bookService.insertBooks(books);
        return "view/books/bookView";
        
        
        
	}
}
