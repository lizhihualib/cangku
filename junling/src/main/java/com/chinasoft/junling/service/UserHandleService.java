package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;

public interface UserHandleService {
	public List<Books> query(String lID);
	public void add();
	public boolean delete(int[] ids,int lID);
	public void update();
	public Users personalInformation(int lID);

	
}
