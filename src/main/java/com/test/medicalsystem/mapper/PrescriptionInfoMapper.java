package com.test.medicalsystem.mapper;
import org.apache.ibatis.annotations.Param;
import com.test.medicalsystem.entity.PrescriptionInfo;

public interface PrescriptionInfoMapper {

    int insertPrescriptionInfo(PrescriptionInfo record);
    int updatePrescriptionInfoBystuRegister(PrescriptionInfo record);
    int deleteBystuRegister(String stuRegister);

    PrescriptionInfo selectBystuRegister(String stuRegister);
}
