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
import com.chinasoft.junling.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookControl {

	@Resource
	private IBookService bookService;
	/*@Resource
	private Books books;*/

	
	
	@RequestMapping(value="/querybooks") 
	@ResponseBody
	public Map queryBooks(HttpSession session,Books books){
		Map map=new HashMap<String,Object>();
		List<Books> rows=bookService.queryBooks(books);
		       
		map.put("rows", rows);
		return map;
	}
	
	
	@RequestMapping(value="/deletebooks")
	@ResponseBody
	public Integer deleteBooks(@RequestParam("ids[]") String[] ids){
		System.out.println(Arrays.toString(ids));
		Integer row=bookService.deleteBooks(ids);
		return row;
	}
	
	
	@RequestMapping(value="/updatebooks")
	@ResponseBody
	public Integer updateBooks(Books books){
		System.out.println("接收到的数据： "+books.toString());
		Integer row=bookService.updateBooks(books);
		return 1;
	}
	
	
	@RequestMapping(value="/insertbooks",method=RequestMethod.POST)
	@ResponseBody
	public void insertBooks(MultipartFile file,HttpServletRequest req) throws IOException{
		Books books=new Books();
		 
		
		String path="E:\\books";
	    if(!file.isEmpty()){  
        //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹  
        System.out.println("================="+file.getName()+" 长度="+ file.getSize());  
            }  
		String fileName = file.getOriginalFilename(); 
        System.out.println("fileName="+fileName);
        File dir = new File(path,fileName);
        System.out.println("指定路径="+dir);
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        //MultipartFile自带的解析方法  
        file.transferTo(dir);
        books.setbName(req.getParameter("bName"));
	/*	books.setreq.getParameter("uPenName"); */
		String bType=req.getParameter("bType"); 
		String bState=req.getParameter("bState"); 
		String bIntro=req.getParameter("bIntro"); 
		String bClicks=req.getParameter("bClicks"); 
		String bDownloads=req.getParameter("bDownloads"); 
		String bEdittime=req.getParameter("bEdittime"); 
		String bOverTime=req.getParameter("bOverTime");
        
	}
}
