package com.test.medicalsystem.mapper;

import org.apache.ibatis.annotations.Param;

import com.test.medicalsystem.entity.StuInfo;
public interface StuInfoMapper {
    /*
    学生登录
     */
    StuInfo selectUser(@Param("stuNum")String stuNum,@Param("stuPwd")String stuPwd);

    StuInfo selectBystuNum (String stuNum);

    String selectPwdByNum (String stuNum);

    /*
    增加-修改-删除
     */
    int insertStuInfo(StuInfo record);

    int updateStuinfoBystuNum(StuInfo record);

    int deleteBystuNum (String stuNum);





}
