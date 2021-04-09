package com.test.medicalsystem.mapper;

import java.util.List;

import com.test.medicalsystem.entity.MedicInfo;
import com.test.medicalsystem.request.MedicQuery;
import com.test.medicalsystem.result.*;

public interface MedicInfoMapper {

    int deleteByPrimaryKey(Integer mid);

    int insert(MedicInfo record);

    int insertSelective(MedicInfo record);

    MedicInfo selectByPrimaryKey(Integer mid);

    int  updateByPrimarySelective(MedicInfo record);

    int updateByPrimaryKey(MedicInfo record);
    //分页查询
    List<MedicInfo>selectByQueryCondition(MedicQuery query);

    //分页查询总数
    Integer selectTotalCount(MedicQuery query);

    //下架药品

    int  downMedic(Integer mid);
    //重新上架药品
    int  upAgainMedic(Integer mid);

    List<MedicInfo> selectDownMedic();















}
