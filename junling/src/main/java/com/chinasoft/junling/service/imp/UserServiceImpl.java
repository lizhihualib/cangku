package com.chinasoft.junling.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.junling.bean.Users;
import com.chinasoft.junling.dao.UsersDao;
import com.chinasoft.junling.service.IUsersService;
@Service("usersService")
public class UserServiceImpl implements IUsersService{
	@Resource
	private UsersDao usersdao;
	
	@Override
	public List<Users> queryAuthors(Users users) {
		return usersdao.queryAuthors(users);
	}

	@Override
	public List<Users> queryReaders(Users users) {
		return usersdao.queryReaders(users);
	}

	@Override
	public boolean insertUser(Users users) {
		return usersdao.insertUser(users);
	}

	@Override
	public boolean deleteUser(int[] uId) {
		return usersdao.deleteUser(uId);
	}

	@Override
	public boolean updateUser(Users users) {
		return usersdao.updateUser(users);
	}

	@Override
	public int count(Users users) {
		return usersdao.count(users);
	}

	@Override
	public int count1(Users users) {
		return usersdao.count1(users);
	}


	

}
