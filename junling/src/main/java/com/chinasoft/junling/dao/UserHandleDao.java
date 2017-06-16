package com.chinasoft.junling.dao;

import java.util.List;

import com.chinasoft.junling.bean.Books;

public interface UserHandleDao {
	public List<Books> queryCollect();
	public void addCollect();
	public void deleteCollect();
	public void updateCollect();
}
