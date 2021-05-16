package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.RegisterInfo;
import com.test.medicalsystem.request.RegisterQuery;
import com.test.medicalsystem.result.PageResult;

import java.util.List;

public interface RegisterInfoService {


    void insertRegisterinfo(RegisterInfo record);

    void updateRegisterInfoByNum(RegisterInfo record);


    //分页查询
    PageResult<List<RegisterInfo>> selectByQueryCondition(RegisterQuery query);

    PageResult<List<RegisterInfo>> selectAllForDoc(RegisterQuery query);
//    Integer selectDocTotal(RegisterQuery query);
//    List<RegisterInfo>selectAllForDoc(RegisterQuery query);
    void deleteBystuRegister(String stuRegister);

    RegisterInfo  selectBystuRegister(String stuRegister);

    RegisterInfo selectBytimeandNum(String stuNum,String illDate);

}
