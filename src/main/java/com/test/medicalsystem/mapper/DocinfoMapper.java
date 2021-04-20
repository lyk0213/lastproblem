package com.test.medicalsystem.mapper;

import com.test.medicalsystem.request.docinfoQuery;
import org.apache.ibatis.annotations.Param;
import com.test.medicalsystem.entity.DocInfo;

import java.util.List;

public interface DocinfoMapper {
    /*
    医生登录
     */

    DocInfo selectUser(@Param("docNum")String docNum,@Param("docPwd")String docPwd);


    DocInfo selectBydocNum(String docNum);

    int   insertDocInfo(DocInfo record);
    int updateDocInfoBydocNum(DocInfo record);
    int deleteBydocNum(String docNum);
    /*
    分页查找
     */

    Integer selectTotalCount(docinfoQuery query);
    List<DocInfo> selectByQueryCondition(docinfoQuery query);




}
