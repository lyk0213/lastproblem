package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.MedicNewsInfo;
import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.request.medicNewQuery;

import java.util.List;

public interface MedicNewsInfoService {

    //增加
    void insertMedicNewsInfo(MedicNewsInfo record);
    void updateMedicNewsInfoBymedicNum(MedicNewsInfo record);
    void deleteBymedicNum(String medicNum);

    //返回信息
    MedicNewsInfo selectBymedicNum (String medicNum);

    //分页查询
    PageResult<List<MedicNewsInfo>>  selectByQueryCondition(medicNewQuery query);
}
