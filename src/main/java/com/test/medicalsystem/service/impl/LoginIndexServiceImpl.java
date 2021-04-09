package com.test.medicalsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.LoginIndex;
import com.test.medicalsystem.mapper.LoginIndexMapper;
import com.test.medicalsystem.service.LoginIndexService;



@Service
public class LoginIndexServiceImpl implements LoginIndexService{

    @Autowired
    private LoginIndexMapper loginIndexMapper;


    public LoginIndex loginall(String num, String pwd) {
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(num)||StringUtils.isEmpty(pwd)) {
            return null;
        }

        LoginIndex admin =loginIndexMapper.selectUserno(num, pwd);
        if (admin!=null&&admin.getUserid().equals(num)) {
            admin.setUserpwd("********");
            return loginIndexMapper.selectUserno(num, pwd);
        }



        return null;
    }




}
