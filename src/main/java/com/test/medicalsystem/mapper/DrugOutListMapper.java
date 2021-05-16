package com.test.medicalsystem.mapper;
import com.test.medicalsystem.entity.DrugOut;
import com.test.medicalsystem.request.DrugListQuery;

import java.util.List;

public interface DrugOutListMapper {
    //搜查通过病历单号
    DrugOut selectBystuRegister(String stuRegister);
    //增删改
    int insertDrugList(DrugOut record);
    int updateDrugOutBystuRegister(DrugOut record);
    int deleteBystuRegister(String stuRegister);

    //
    Integer selectTotalCount(DrugListQuery query);
    List<DrugOut> selectByQueryCondition(DrugListQuery query);
}
