package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Books;

public interface UserHandleService {
	public List<Books> query(String lID);
	public void add();
	public boolean delete(int[] ids);
	public void update();

	
}
