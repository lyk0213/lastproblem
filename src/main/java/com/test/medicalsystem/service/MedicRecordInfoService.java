package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.MedicRecordInfo;

public interface MedicRecordInfoService {

    void insertMedicRecordInfo(MedicRecordInfo record);
    void updateMedicRecordInfoBystuRegister(MedicRecordInfo record);
    void deleteBystuRegister(String stuRegister);
}
