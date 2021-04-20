package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.DocInfo;
import com.test.medicalsystem.request.docinfoQuery;
import com.test.medicalsystem.result.PageResult;

import java.util.List;

public interface DocInfoService {
    /*
    医生登录
     */
    DocInfo loginDoc(String num,String pwd);


    DocInfo selectBydocNum(String docNum);

    void    insertDocInfo(DocInfo record);
    void    updateDocInfoBydocNum(DocInfo record);
    void    deleteBydocNum(String docNum);

    //分页查询
    PageResult<List<DocInfo>> selectByQueryCondition(docinfoQuery query);

}
