package com.test.medicalsystem.service.impl;
import com.test.medicalsystem.request.medicNewQuery;
import com.test.medicalsystem.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.MedicNewsInfo;
import com.test.medicalsystem.mapper.MedicNewsInfoMapper;
import com.test.medicalsystem.service.MedicNewsInfoService;

import java.util.List;

@Service
public class MedicNewsInfoServiceImpl implements MedicNewsInfoService{
    @Autowired
    private MedicNewsInfoMapper medicNewsInfoMapper;


    //增加药物信息表
    public void insertMedicNewsInfo(MedicNewsInfo record) {
        medicNewsInfoMapper.insertMedicNewsInfo(record);
    }

    public void updateMedicNewsInfoBymedicNum(MedicNewsInfo record) {
        medicNewsInfoMapper.updateMedicNewsInfoBymedicNum(record);
    }

    public void deleteBymedicNum(String medicNum) {
        medicNewsInfoMapper.deleteBymedicNum(medicNum);
    }

    public MedicNewsInfo selectBymedicNum(String medicNum) {
        MedicNewsInfo medicNewsInfo = medicNewsInfoMapper.selectBymedicNum(medicNum);
        return medicNewsInfo;
    }

    public PageResult<List<MedicNewsInfo>> selectByQueryCondition(medicNewQuery query) {
        query.setPage((query.getPage()-1)* query.getLimit());
        List<MedicNewsInfo> MedicList =medicNewsInfoMapper.selectByQueryCondition(query);

        int toCount = medicNewsInfoMapper.selectTotalCount(query);
        PageResult<List<MedicNewsInfo>> result = new PageResult<List<MedicNewsInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(toCount);

        Double pageSize = Math.ceil(((double) toCount/query.getLimit()));
        result.setPageCount(pageSize.intValue());
        result.setData(MedicList);
        return result;
    }
}
