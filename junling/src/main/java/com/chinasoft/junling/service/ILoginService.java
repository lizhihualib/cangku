package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Login;

public interface ILoginService {
	  int idCount(Login login);
     Login queryLogin(Login login);
     boolean insertLogin(Login login);
     boolean updateLogin(Login login);
     boolean deleteLogin(String ids);
     int findByName(Login login);
     String total(Login login);
     List <Login> findAll(Login login);
}
