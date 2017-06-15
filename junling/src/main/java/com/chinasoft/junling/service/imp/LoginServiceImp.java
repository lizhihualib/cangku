package com.chinasoft.junling.service.imp;


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
		return false;
	}

	@Override
	public boolean updatePwd(Login login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateType(Login login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLogin(Login login) {
		// TODO Auto-generated method stub
		return false;
	}

}
