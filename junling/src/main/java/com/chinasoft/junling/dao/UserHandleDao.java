package com.chinasoft.junling.dao;

import java.util.List;

import com.chinasoft.junling.bean.Books;

public interface UserHandleDao {
	public List<Books> queryCollect();
	public void addCollect();
	public boolean deleteCollect(int[] ids);
	public void updateCollect();
}
