package com.test.medicalsystem.mapper;

import org.apache.ibatis.annotations.Param;

import com.test.medicalsystem.entity.LoginIndex;

public interface LoginIndexMapper {

    /**
     * 登录
     * @param userid
     * @param userpwd
     * @return
     */
    LoginIndex selectUserno(@Param("userid")String userid,@Param("userpwd")String userpwd);

}
