package com.chinasoft.junling.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.junling.bean.Books;
import com.chinasoft.junling.bean.Users;
import com.chinasoft.junling.dao.LoginDao;
import com.chinasoft.junling.dao.UserHandleDao;
import com.chinasoft.junling.service.UserHandleService;
@Service("userHandleInterface")
@Transactional
public class UserHandeleServiceImpl implements UserHandleService{
	@Resource
	private UserHandleDao userHandleDao;
	@Override
	public List<Books> query(String lID) {
		List<Books> listBooks = userHandleDao.queryCollect(lID);
		return listBooks;
		
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int[] ids,int lID) {
		// TODO Auto-generated method stub
		return userHandleDao.deleteCollect(ids,lID);
	}

	@Override
	public Users personalInformation(int lID) {
		// TODO Auto-generated method stub
		return userHandleDao.queryUser(lID);
	}

	@Override
	public int updateInformation(Users user) {
		// TODO Auto-generated method stub
		int falg1 = userHandleDao.updateInformation(user);
		int falg2 = userHandleDao.updateInformation1(user);
		System.out.println(falg1);
		System.out.println(falg2);
		return 0;
	}
	
}
