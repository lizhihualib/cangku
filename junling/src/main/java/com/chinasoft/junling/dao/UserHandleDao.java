package com.chinasoft.junling.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;

public interface UserHandleDao {
	public List<Books> queryCollect(String lID);
	public void addCollect();
	public boolean deleteCollect(@Param("array") int[] ids,@Param("id") int lID);
	public void updateCollect();
	public Users queryUser(int lID);
	public int updateInformation(Users user);
	public int updateInformation1(Users user);
	public Users querySignState(int id);
	public int updateSignState(@Param("id") int id, @Param("timeNow") String timeNow,@Param("addBeans") int val);
	public Users querySignIn(int id);
	
}
