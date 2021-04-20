package com.test.medicalsystem.mapper;
import org.apache.ibatis.annotations.Param;
import com.test.medicalsystem.entity.MedicRecordInfo;

public interface MedicRecordInfoMapper {

    int insertMedicRecordInfo(MedicRecordInfo record);
    int updateMedicRecordInfoBystuRegister(MedicRecordInfo record);
    int deleteBystuRegister(String stuRegister);

}
