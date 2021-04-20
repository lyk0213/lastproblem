package com.test.medicalsystem.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.AdminInfo;
import com.test.medicalsystem.mapper.AdminInfoMapper;
import com.test.medicalsystem.service.AdminInfoService;

@Service
public class AdminInfoServiceImpl implements AdminInfoService{
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    //管理员登录查询
    public AdminInfo loginAdmin(String num, String pwd) {
        if (StringUtils.isEmpty(num)||StringUtils.isEmpty(pwd)) {
            return null;
        }
        AdminInfo adminInfo=adminInfoMapper.selectUser(num, pwd);
        if (adminInfo!=null&&adminInfo.getAdminNum().equals(num)){
            adminInfo.setAdminPwd("********");
            return adminInfoMapper.selectUser(num, pwd);
        }
        return null;
    }

    public AdminInfo selectNews(String adminNum) {
        AdminInfo adminInfo = adminInfoMapper.selectNews(adminNum);
        return adminInfo;
    }
}
