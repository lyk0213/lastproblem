package com.test.medicalsystem.mapper;

import org.apache.ibatis.annotations.Param;

import com.test.medicalsystem.entity.DocInfo;

public interface DocinfoMapper {
    /*
    医生登录
     */

    DocInfo selectUser(@Param("docNum")String docNum,@Param("docPwd")String docPwd);


    DocInfo selectBydocNum(String docNum);

    int   insertDocInfo(DocInfo record);
    int updateDocInfoBydocNum(DocInfo record);
    int deleteBydocNum(String docNum);


}
