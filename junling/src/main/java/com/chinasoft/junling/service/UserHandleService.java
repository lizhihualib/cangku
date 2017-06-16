package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Books;

public interface UserHandleService {
	public List<Books> query();
	public void add();
	public void delete();
	public void update();

	
}
