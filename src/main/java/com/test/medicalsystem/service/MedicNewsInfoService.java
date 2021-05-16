package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.MedicNewsInfo;
import com.test.medicalsystem.request.medicNewQuery;
import com.test.medicalsystem.result.PageResult;

import java.util.List;

public interface MedicNewsInfoService {

    //返回信息
    MedicNewsInfo selectBymedicNum (String medicNum);
    MedicNewsInfo selectBymedicName (String medicName);
    //增,删,改
    void insertMedicNewsInfo(MedicNewsInfo record);
    void updateMedicNewsInfoBymedicNum(MedicNewsInfo record);
    void deleteBymedicNum(String medicNum);

    //分页查询
    PageResult<List<MedicNewsInfo>>  selectByQueryCondition(medicNewQuery query);

    List<MedicNewsInfo> selectAll();

}
