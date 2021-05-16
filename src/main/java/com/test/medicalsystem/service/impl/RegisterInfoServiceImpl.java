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
        for (RegisterInfo Register : RegisterList) {
            if ("0".equals(Register.getTreatmentType())) {
                Register.setTreatmentType("未挂号");
//                System.out.println(Register.getTreatmentType());0为挂号，1为已挂号，2为已就诊
            }else if ("1".equals(Register.getTreatmentType())){
                Register.setTreatmentType("已挂号");
            }else if ("2".equals(Register.getTreatmentType())){
                Register.setTreatmentType("已就诊");
            }
        }
        int totalCount=registerInfoMapper.selectTotalCount(query);//查询总数目
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(totalCount);

        Double pageSize=Math.ceil(((double) totalCount/ query.getLimit()));//总页数
        result.setPageCount(pageSize.intValue());
        result.setData(RegisterList);
        return result;
    }

    public PageResult<List<RegisterInfo>> selectAllForDoc(RegisterQuery query) {
        query.setPage((query.getPage()-1) * query.getLimit());
        //医生查询全部
        List<RegisterInfo> RegisterList = registerInfoMapper.selectAllForDoc(query);

        for (RegisterInfo Register : RegisterList) {
            if ("0".equals(Register.getTreatmentType())) {
                Register.setTreatmentType("未挂号");
            }else if ("1".equals(Register.getTreatmentType())){
                Register.setTreatmentType("已挂号");
            }else if ("2".equals(Register.getTreatmentType())){
                Register.setTreatmentType("已就诊");
            }
        }
        int toCount1=registerInfoMapper.selectDocTotal(query);
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(toCount1);

        Double pageSize=Math.ceil(((double) toCount1/ query.getLimit()));
        result.setPageCount(pageSize.intValue());
        result.setData(RegisterList);
        return result;
    }

    public void deleteBystuRegister(String stuRegister) {
        registerInfoMapper.deleteBystuRegister(stuRegister);

    }

    public RegisterInfo selectBystuRegister(String stuRegister) {
        RegisterInfo registerInfo = registerInfoMapper.selectBystuRegister(stuRegister);
        return registerInfo;
    }

    public RegisterInfo selectBytimeandNum(String stuNum, String illDate) {
        RegisterInfo registerInfo = registerInfoMapper.selectBytimeandNum(stuNum, illDate);
        return registerInfo;
    }
}
