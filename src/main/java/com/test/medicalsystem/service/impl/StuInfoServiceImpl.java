package com.test.medicalsystem.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.mapper.StuInfoMapper;
import com.test.medicalsystem.service.StuInfoService;

@Service
public class StuInfoServiceImpl implements StuInfoService{
    @Autowired
    private StuInfoMapper stuInfoMapper;

    //学生登录查询
    public StuInfo loginStu(String num, String pwd) {
        if (StringUtils.isEmpty(num)||StringUtils.isEmpty(pwd)) {
            return null;
        }
        StuInfo stuInfo=stuInfoMapper.selectUser(num, pwd);
        if (stuInfo!=null&&stuInfo.getStuNum().equals(num)){
            stuInfo.setStuPwd("********");
            return stuInfoMapper.selectUser(num, pwd);
        }
        return null;
    }

    public StuInfo selectBystuNum(String stuNum) {
        StuInfo stuInfo = stuInfoMapper.selectBystuNum(stuNum);
        //
        return stuInfo;
    }

    public String selectPwdByNum(String stuNum) {
        return stuInfoMapper.selectPwdByNum(stuNum);
    }

    public void insertStuInfo(StuInfo record) {
        stuInfoMapper.insertStuInfo(record);
    }

    public void updateStuinfoBystuNum(StuInfo record) {
        stuInfoMapper.updateStuinfoBystuNum(record);

    }

    public void deleteBystuNum(String stuNum) {
        stuInfoMapper.deleteBystuNum(stuNum);
    }
}
