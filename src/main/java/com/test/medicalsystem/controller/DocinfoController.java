package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.DocInfo;
import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.entity.MedicRecordInfo;
import com.test.medicalsystem.entity.RegisterInfo;

import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.DocInfoService;
import com.test.medicalsystem.service.RegisterInfoService;
import com.test.medicalsystem.service.MedicRecordInfoService;

@RestController
@RequestMapping("/docinfo")
public class DocinfoController {
    @Autowired
    private DocInfoService docInfoService;

    @Autowired
    private RegisterInfoService registerInfoService;

    @Autowired
    private MedicRecordInfoService medicRecordInfoService;

    @RequestMapping(value = "/selectByDocNum")
    public Result<DocInfo> selectByDocNum(String docNum){
        Result<DocInfo> result = new Result<DocInfo>();
        try {
            DocInfo docInfo = docInfoService.selectBydocNum(docNum);
            if (docInfo == null){
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该医生");
                return result;
            }
            result.setData(docInfo);
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //修改医生信息
    @RequestMapping(value = "/updateDocInfoBydocNum")
    public  Result<String> updateDocInfoBydocNum(DocInfo docInfo){
        if ("".equals(docInfo.getDocPwd())){
            docInfo.setDocPwd(null);
        }
        System.out.println("修改信息"+docInfo);
        Result<String > result = new Result<String>();
        try {
            docInfoService.updateDocInfoBydocNum(docInfo);
            result.setData("修改成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //增加医生信息
    @RequestMapping(value = "/insertDocInfo")
    public Result<String> insertDocInfo(DocInfo docInfo,HttpSession session){
        Result<String> result = new Result<String>();
        try {
            docInfo.setDocType("1");
            docInfoService.insertDocInfo(docInfo);
            result.setData("添加成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return  result;
    }

    //删除医生信息通过DocNum
    @RequestMapping(value = "/deleteBydocNum")
    public Result<String> deleteBydocNum(String docNum){
    Result<String> result = new Result<String>();
        try {
            docInfoService.deleteBydocNum(docNum);
            result.setData("删除成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //通过病历单号码查找到当前病历单的内容
    @RequestMapping(value = "/selectBystuRegister")
    public Result<RegisterInfo> selectBystuRegister(String stuRegister){
        Result<RegisterInfo> result = new Result<RegisterInfo>();
        try {
            RegisterInfo a =registerInfoService.selectBystuRegister(stuRegister);
            if (a==null){
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该资源");
            }
            result.setData(a);
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }


    //点击添加学生病例单
    @RequestMapping(value = "addMedicRecord")
    public Result<String>  addMedicRecord(MedicRecordInfo medicRecordInfo,HttpSession session){
        Result<String> result = new Result<String>();
        try{
            DocInfo docInfo=(DocInfo) session.getAttribute("docInfo");
            int did = 0;
            if (docInfo!=null){
                did = docInfo.getDid();
            }else {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("登录失效，请重新登录");
                result.setData(null);
                return result;
            }
            medicRecordInfoService.insertMedicRecordInfo(medicRecordInfo);
            result.setData("增加成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }








}
