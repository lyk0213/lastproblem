package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.StuInfo;
public interface StuInfoService {
    /*
    学生登录
     */
    StuInfo loginStu(String num,String pwd);

    StuInfo selectBystuNum(String stuNum);

    String selectPwdByNum (String stuNum);

    /*
    增加-修改-删除
     */

    void insertStuInfo(StuInfo record);

    void updateStuinfoBystuNum(StuInfo record);

    void deleteBystuNum (String stuNum);



}
