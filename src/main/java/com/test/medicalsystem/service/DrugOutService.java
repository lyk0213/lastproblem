package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.DrugOut;
import com.test.medicalsystem.request.DrugListQuery;
import com.test.medicalsystem.result.PageResult;

import java.util.List;


public interface DrugOutService {

    DrugOut selectBystuRegister(String stuRegister);
    //增删改
    void insertDrugList(DrugOut record);
    void updateDrugOutBystuRegister(DrugOut record);
    void deleteBystuRegister(String stuRegister);
    //分页查询
    PageResult<List<DrugOut>>  selectByQueryCondition(DrugListQuery query);

}
