package com.test.medicalsystem.service.impl;
import com.test.medicalsystem.request.docinfoQuery;
import com.test.medicalsystem.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.medicalsystem.config.ConfigUtil;

import com.test.medicalsystem.entity.DocInfo;
import com.test.medicalsystem.mapper.DocinfoMapper;
import com.test.medicalsystem.service.DocInfoService;

import java.util.List;

@Service
public class DocInfoServiceImpl implements DocInfoService{
    @Autowired
    private DocinfoMapper docinfoMapper;
    //医生登录查询
    public DocInfo loginDoc(String num, String pwd) {
        if (StringUtils.isEmpty(num)||StringUtils.isEmpty(pwd)) {
            return null;
        }
        DocInfo docInfo=docinfoMapper.selectUser(num, pwd);
        if(docInfo!=null&&docInfo.getDocNum().equals(num)){
            docInfo.setDocPwd("********");
            return docinfoMapper.selectUser(num, pwd);
        }
        return null;
    }

    public DocInfo selectBydocNum(String docNum) {
        DocInfo docInfo =docinfoMapper.selectBydocNum(docNum);
        return docInfo;
    }

    public void insertDocInfo(DocInfo record) {
        docinfoMapper.insertDocInfo(record);

    }

    public void updateDocInfoBydocNum(DocInfo record) {
        docinfoMapper.updateDocInfoBydocNum(record);

    }

    public void deleteBydocNum(String docNum) {
        docinfoMapper.deleteBydocNum(docNum);
    }

    public PageResult<List<DocInfo>> selectByQueryCondition(docinfoQuery query) {
        query.setPage((query.getPage()-1)* query.getLimit());
        List<DocInfo> DocList =docinfoMapper.selectByQueryCondition(query);

        int toCount = docinfoMapper.selectTotalCount(query);
        PageResult<List<DocInfo>> result = new PageResult<List<DocInfo>>();
        result.setLimit(query.getLimit());
        result.setCount(toCount);

        Double pageSize = Math.ceil(((double) toCount/query.getLimit()));
        result.setPageCount(pageSize.intValue());
        result.setData(DocList);
        return result;
    }
}
