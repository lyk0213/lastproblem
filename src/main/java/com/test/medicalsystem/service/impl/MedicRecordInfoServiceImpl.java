package com.test.medicalsystem.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.MedicRecordInfo;
import com.test.medicalsystem.mapper.MedicRecordInfoMapper;
import com.test.medicalsystem.service.MedicRecordInfoService;

@Service
public class MedicRecordInfoServiceImpl implements MedicRecordInfoService{
    @Autowired
    private MedicRecordInfoMapper medicRecordInfoMapper;

    //增加病例表
    public void insertMedicRecordInfo(MedicRecordInfo record) {
        medicRecordInfoMapper.insertMedicRecordInfo(record);
    }

    public void updateMedicRecordInfoBystuRegister(MedicRecordInfo record) {
        medicRecordInfoMapper.updateMedicRecordInfoBystuRegister(record);
    }

    public void deleteBystuRegister(String stuRegister) {
        medicRecordInfoMapper.deleteBystuRegister(stuRegister);

    }

    public MedicRecordInfo selectBystuRegister(String stuRegister) {
        MedicRecordInfo medicRecordInfo=medicRecordInfoMapper.selectBystuRegister(stuRegister);
        return medicRecordInfo;
    }
}
