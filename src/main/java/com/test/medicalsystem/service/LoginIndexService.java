package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.LoginIndex;

public interface LoginIndexService {

    /**
     * 登录
     * @param num
     * @param pwd
     * @return
     */
    LoginIndex  loginall(String num,String pwd);


}
