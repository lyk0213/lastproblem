package com.test.medicalsystem.mapper;

import org.apache.ibatis.annotations.Param;

import com.test.medicalsystem.entity.AdminInfo;

public interface AdminInfoMapper {

    /**
     * 登录
     */

    AdminInfo selectUser(@Param("adminNum")String adminNum,@Param("adminPwd")String adminPwd);


    AdminInfo selectNews(String adminNum);

}
