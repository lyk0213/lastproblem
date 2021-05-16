package com.test.medicalsystem.mapper;

import java.util.List;


import com.test.medicalsystem.entity.RegisterInfo;
import com.test.medicalsystem.request.RegisterQuery;
import org.apache.ibatis.annotations.Param;

public interface RegisterInfoMapper {


    int insertRegisterinfo(RegisterInfo record);

    int updateRegisterInfoByNum(RegisterInfo record);


    //分页查询总数
    Integer selectTotalCount(RegisterQuery query);
    //分页查询
    List<RegisterInfo>selectByQueryCondition(RegisterQuery query);

    int deleteBystuRegister(String stuRegister);


    //医生端对于病例的全部遍历搜索
    Integer selectDocTotal(RegisterQuery query);
    List<RegisterInfo>selectAllForDoc(RegisterQuery query);

    RegisterInfo  selectBystuRegister(String stuRegister);

    RegisterInfo selectBytimeandNum(@Param("stuNum")String stuNum, @Param("illDate")String illDate);


}
