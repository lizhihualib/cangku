package com.chinasoft.junling.service;

import com.chinasoft.junling.bean.Login;

public interface ILoginService {
     Login queryLogin(Login login);
     boolean insertLogin(Login login);
     boolean updatePwd(Login login);
     boolean updateType(Login login);
     boolean deleteLogin(Login login);
}
