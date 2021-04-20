package com.test.medicalsystem.service;

import com.test.medicalsystem.entity.PrescriptionInfo;

public interface PrescriptionInfoService {
    void insertPrescriptionInfo(PrescriptionInfo record);
    void updatePrescriptionInfoBystuRegister(PrescriptionInfo record);
    void deleteBystuRegister(String stuRegister);
}
