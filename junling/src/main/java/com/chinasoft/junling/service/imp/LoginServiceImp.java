package com.chinasoft.junling.service.imp;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.junling.bean.Login;
import com.chinasoft.junling.dao.LoginDao;
import com.chinasoft.junling.service.ILoginService;
@Service("loginService")
public class LoginServiceImp implements ILoginService{
	@Resource
	private LoginDao loginDao;
	@Override
	public Login queryLogin(Login login) {
		// TODO Auto-generated method stub
		loginDao.queryLogin(login);
		 System.out.println(loginDao.queryLogin(login));
		return loginDao.queryLogin(login);
	}

	@Override
	public boolean insertLogin(Login login) {
		// TODO Auto-generated method stub
		return loginDao.insertLogin(login);
	}

	@Override
	public boolean updateLogin(Login login) {
		// TODO Auto-generated method stub
		return loginDao.updateLogin(login);
	}


	@Override
	public boolean deleteLogin(String ids) {
		// TODO Auto-generated method stub
		
		return loginDao.deleteLogin(ids);
	}

	@Override
	public List<Login> findAll(String type) {
		// TODO Auto-generated method stub
		return loginDao.findAll(type);
	}

	@Override
	public Login findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
