package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.DocInfo;
public interface DocInfoService {
    /*
    医生登录
     */
    DocInfo loginDoc(String num,String pwd);


    DocInfo selectBydocNum(String docNum);

    void    insertDocInfo(DocInfo record);
    void    updateDocInfoBydocNum(DocInfo record);
    void    deleteBydocNum(String docNum);

}
