package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Login;

public interface ILoginService {
     Login queryLogin(Login login);
     boolean insertLogin(Login login);
     boolean updateLogin(Login login);
     boolean deleteLogin(String ids);
     Login findById(int id);
     List <Login> findAll(String type);
}
