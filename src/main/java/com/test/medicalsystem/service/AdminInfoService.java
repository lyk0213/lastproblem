package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.AdminInfo;

public interface AdminInfoService {
    /*
    管理员登录
     */

    AdminInfo loginAdmin(String num,String pwd);

    AdminInfo selectNews(String adminNum);
}
