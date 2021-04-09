package com.test.medicalsystem.service.impl;


import com.test.medicalsystem.request.RegisterQuery;
import com.test.medicalsystem.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.RegisterInfo;
import com.test.medicalsystem.mapper.RegisterInfoMapper;
import com.test.medicalsystem.service.RegisterInfoService;

import java.util.List;

@Service
public class RegisterInfoServiceImpl implements RegisterInfoService{
    @Autowired
    private RegisterInfoMapper registerInfoMapper;


    public void insertRegisterinfo(RegisterInfo record) {
        registerInfoMapper.insertRegisterinfo(record);

    }

    public void updateRegisterInfoByNum(RegisterInfo record) {
        registerInfoMapper.updateRegisterInfoByNum(record);

    }

    public PageResult<List<RegisterInfo>> selectByQueryCondition(RegisterQuery query) {
        query.setPage((query.getPage() - 1) * query.getLimit());
        List<RegisterInfo> RegisterList=registerInfoMapper.selectByQueryCondition(query);
//        for (RegisterInfo Register : RegisterList){
//            if (Register.getStuRegister().length()>= 60){
//                Register.setStuRegister(Register.getStuRegister().substring(0,60));
//            }
//        }
        int totalCount=registerInfoMapper.selectTotalCount(query);//查询总数目
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(totalCount);

        Double pageSize=Math.ceil(((double) totalCount/ query.getLimit()));//总页数
        result.setPageCount(pageSize.intValue());
        result.setData(RegisterList);
        return result;
    }
}
