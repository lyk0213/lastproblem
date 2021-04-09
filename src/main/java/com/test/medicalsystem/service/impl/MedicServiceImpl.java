package com.test.medicalsystem.service.impl;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.MedicInfo;
import com.test.medicalsystem.request.MedicQuery;
import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.service.MedicService;
import com.test.medicalsystem.mapper.MedicInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicServiceImpl implements MedicService {

    @Autowired
    private MedicInfoMapper medicInfoMapper;

    public PageResult<List<MedicInfo>> selectByQueryCondition(MedicQuery query) {
        query.setPage((query.getPage() - 1) * query.getLimit());
        List<MedicInfo> MedicList = medicInfoMapper.selectByQueryCondition(query);
        for (MedicInfo Medic : MedicList) {
            if (Medic.getMedFunction().length() >= 60) {
                Medic.setMedFunction(Medic.getMedFunction().substring(0, 60));
            }//缩短药物简介
            Medic.setImgName(ConfigUtil.BOOKIMAGE_URI + Medic.getImgName());//设置路径??
        }
        int totalCount = medicInfoMapper.selectTotalCount(query);//查询总数目
        PageResult<List<MedicInfo>> result = new PageResult<List<MedicInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(totalCount);

        Double pageSize = Math.ceil(((double) totalCount / query.getLimit()));//总页数
        result.setPageCount(pageSize.intValue());
        result.setData(MedicList);

        return result;
    }

    public void downMedic(Integer mid) {
        medicInfoMapper.downMedic(mid);
    }

    public void upAgainMedic(Integer mid) {
        medicInfoMapper.upAgainMedic(mid);
    }

    public List<MedicInfo> selectDownMedic() {
        return medicInfoMapper.selectDownMedic();
    }


    public void insertSelective(MedicInfo record) {
        medicInfoMapper.insertSelective(record);

    }

    public void updateMedic(MedicInfo record) {
        medicInfoMapper.updateByPrimarySelective(record);
    }

    public MedicInfo selectByPrimaryKey(Integer mid) {
        MedicInfo medicInfo = medicInfoMapper.selectByPrimaryKey(mid);
        medicInfo.setImgName(ConfigUtil.BOOKIMAGE_URI + medicInfo.getImgName());
        return medicInfo;
    }


}
