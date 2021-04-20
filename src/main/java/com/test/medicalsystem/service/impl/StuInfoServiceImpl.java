package com.test.medicalsystem.service.impl;
import com.test.medicalsystem.request.stuinfoQuery;
import com.test.medicalsystem.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.mapper.StuInfoMapper;
import com.test.medicalsystem.service.StuInfoService;

import java.util.List;

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

    public PageResult<List<StuInfo>> selectByQueryCondition(stuinfoQuery query) {
        query.setPage((query.getPage()-1) *query.getLimit());

        List<StuInfo> StuList = stuInfoMapper.selectByQueryCondition(query);
        //做条件

        int toCount = stuInfoMapper.selectTotalCount(query);
        PageResult<List<StuInfo>> result = new PageResult<List<StuInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(toCount);

        Double pageSize = Math.ceil(((double) toCount/ query.getLimit()));
        result.setPageCount(pageSize.intValue());
        result.setData(StuList);
        return result;
    }
}
