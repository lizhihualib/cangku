package com.chinasoft.junling.dao;


import java.util.List;

import com.chinasoft.junling.bean.Login;

public  interface  LoginDao {
	int idCount(Login login);
   Login queryLogin(Login login);
   boolean insertLogin(Login login);
   boolean updateLogin(Login login);
   boolean deleteLogin(String ids);      
   List <Login> findAll(Login login);
    String total(Login login);
   int findByName(Login login);
	
}
