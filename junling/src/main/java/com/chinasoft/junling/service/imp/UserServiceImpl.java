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
	public Users queryUser(Users users) {
		return usersdao.queryUser(users);
	}

	@Override
	public boolean insertUser(Users users) {
		return usersdao.insertUser(users);
	}

	@Override
	public boolean deleteUser(String uId) {
		return usersdao.deleteUser(uId);
	}

	@Override
	public boolean updateUser(Users users) {
		return usersdao.updateUser(users);
	}

	@Override
	public List<Users> queryUsers(Users users) {
		
		return usersdao.queryUsers(users);
	}

}
