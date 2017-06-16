package com.chinasoft.junling.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.dao.LoginDao;
import com.chinasoft.junling.dao.UserHandleDao;
import com.chinasoft.junling.service.UserHandleService;
@Service("userHandleInterface")
public class UserHandeleServiceImpl implements UserHandleService{
	@Resource
	private UserHandleDao userHandleDao;
	@Override
	public List<Books> query() {
		List<Books> listBooks = userHandleDao.queryCollect();
		return listBooks;
		
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
