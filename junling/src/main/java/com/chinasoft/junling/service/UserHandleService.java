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
	public int updateInformation(Users user);
	public int updateSignState(int id, String timeNow, int val);
	public Users querySignIn(int id);

	
}
