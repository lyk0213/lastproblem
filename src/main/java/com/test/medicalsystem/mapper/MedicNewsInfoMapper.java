package com.test.medicalsystem.mapper;
import org.apache.ibatis.annotations.Param;
import com.test.medicalsystem.entity.MedicNewsInfo;
import com.test.medicalsystem.request.medicNewQuery;

import java.util.List;

public interface MedicNewsInfoMapper {
    //新增药物信息表
    int insertMedicNewsInfo(MedicNewsInfo record);
    int updateMedicNewsInfoBymedicNum(MedicNewsInfo record);
    int deleteBymedicNum(String medicNum);

    //药物分页查询
    Integer selectTotalCount(medicNewQuery query);
    List<MedicNewsInfo> selectByQueryCondition(medicNewQuery query);

    //通过查询药物编号返回药物信息
    MedicNewsInfo selectBymedicNum (String medicNum);


}
