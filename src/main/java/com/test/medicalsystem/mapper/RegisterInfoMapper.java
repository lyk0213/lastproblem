package com.test.medicalsystem.mapper;

import java.util.List;


import com.test.medicalsystem.entity.RegisterInfo;
import com.test.medicalsystem.request.RegisterQuery;

public interface RegisterInfoMapper {


    int insertRegisterinfo(RegisterInfo record);

    int updateRegisterInfoByNum(RegisterInfo record);


    //分页查询总数
    Integer selectTotalCount(RegisterQuery query);
    //分页查询
    List<RegisterInfo>selectByQueryCondition(RegisterQuery query);


}
