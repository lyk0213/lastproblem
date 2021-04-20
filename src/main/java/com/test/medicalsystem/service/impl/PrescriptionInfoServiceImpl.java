package com.test.medicalsystem.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.PrescriptionInfo;
import com.test.medicalsystem.mapper.PrescriptionInfoMapper;
import com.test.medicalsystem.service.PrescriptionInfoService;

@Service
public class PrescriptionInfoServiceImpl implements PrescriptionInfoService{
    @Autowired
    private PrescriptionInfoMapper prescriptionInfoMapper;

    //增加处方表
    public void insertPrescriptionInfo(PrescriptionInfo record) {
        prescriptionInfoMapper.insertPrescriptionInfo(record);
    }

    public void updatePrescriptionInfoBystuRegister(PrescriptionInfo record) {
        prescriptionInfoMapper.updatePrescriptionInfoBystuRegister(record);
    }

    public void deleteBystuRegister(String stuRegister) {
        prescriptionInfoMapper.deleteBystuRegister(stuRegister);
    }
}
