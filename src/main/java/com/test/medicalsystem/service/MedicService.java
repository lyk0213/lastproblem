package com.test.medicalsystem.service;

import java.util.List;
import com.test.medicalsystem.entity.MedicInfo;
import com.test.medicalsystem.request.MedicQuery;
import com.test.medicalsystem.result.PageResult;

public interface MedicService {

    //新增药品
    void insertSelective(MedicInfo record);

    //修改药品
    void updateMedic(MedicInfo record);

    //通过id查询药品
    MedicInfo selectByPrimaryKey(Integer mid);

    //分页查询
    PageResult<List<MedicInfo>> selectByQueryCondition(MedicQuery query);

    //下架药品
    void  downMedic(Integer mid);

    //重新上架药品
    void   upAgainMedic(Integer mid);
    //查询所有下架药品
    List<MedicInfo> selectDownMedic();




}
