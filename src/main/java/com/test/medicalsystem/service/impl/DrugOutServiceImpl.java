package com.test.medicalsystem.service.impl;
import com.test.medicalsystem.request.DrugListQuery;
import com.test.medicalsystem.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.entity.DrugOut;
import com.test.medicalsystem.mapper.DrugOutListMapper;
import com.test.medicalsystem.service.DrugOutService;

import java.util.List;

@Service
public class DrugOutServiceImpl implements DrugOutService{
    @Autowired
    private DrugOutListMapper drugOutListMapper;

    public DrugOut selectBystuRegister(String stuRegister) {
        DrugOut drugOut =drugOutListMapper.selectBystuRegister(stuRegister);
        return drugOut;
    }

    public void insertDrugList(DrugOut record) {
        drugOutListMapper.insertDrugList(record);
    }

    public void updateDrugOutBystuRegister(DrugOut record) {
        drugOutListMapper.updateDrugOutBystuRegister(record);
    }

    public void deleteBystuRegister(String stuRegister) {
        drugOutListMapper.deleteBystuRegister(stuRegister);
    }

    public PageResult<List<DrugOut>> selectByQueryCondition(DrugListQuery query) {
        query.setPage((query.getPage()-1)* query.getLimit());
        List<DrugOut> drugOutList = drugOutListMapper.selectByQueryCondition(query);

        int toCount = drugOutListMapper.selectTotalCount(query);
        PageResult<List<DrugOut>> result = new PageResult<List<DrugOut>>();
        result.setLimit(query.getLimit());
        result.setCount(toCount);

        Double pageSize= Math.ceil(((double) toCount/query.getLimit()));
        result.setPageCount(pageSize.intValue());
        result.setData(drugOutList);
        return result;
    }
}
