package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.request.stuinfoQuery;

import java.util.List;

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

    //分页查询
    PageResult<List<StuInfo>> selectByQueryCondition(stuinfoQuery query);



}
