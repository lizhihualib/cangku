package com.chinasoft.junling.dao;


import java.util.List;

import com.chinasoft.junling.bean.Login;

public  interface  LoginDao {
   Login queryLogin(Login login);
   boolean insertLogin(Login login);
   boolean updateLogin(Login login);
   boolean deleteLogin(String ids);      
   List <Login> findAll(String type);
   Login findById();
	
}
