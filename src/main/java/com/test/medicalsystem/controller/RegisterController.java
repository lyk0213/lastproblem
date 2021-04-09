package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;

import com.test.medicalsystem.request.RegisterQuery;
import com.test.medicalsystem.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.RegisterInfo;
import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.RegisterInfoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterInfoService registerInfoService;

    @RequestMapping(value = "/insertRegister")
    public Result<String> insertRegister(RegisterInfo registerInfo,HttpSession session){
        Result<String> result = new Result<String>();
        try {
            String a = UUID.randomUUID().toString();
            registerInfo.setTreatmentType("0");
            registerInfo.setStuRegister(a);
            registerInfoService.insertRegisterinfo(registerInfo);
            result.setData("添加成功");

        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/query")
    public PageResult<List<RegisterInfo>> selectByQueryCondition(RegisterQuery query){
        int page =query.getPage();
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        try {
//            String a=query.getStuNum();
//            if (a.equals(null)&&"".equals(a)){
//                result.setCode(ConfigUtil.ERROR_CODE);
//                result.setMsg("请点击查询做查询操作");
//            }else{
                System.out.println(query);
                result =registerInfoService.selectByQueryCondition(query);
                result.setPage(page);
                if (result.getData() == null){
                    result.setCode(ConfigUtil.ERROR_CODE);
                    result.setMsg("未找到任何数据");
 //               }
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/registerdown")
    public Result<String> deleteBystuRegister(String stuRegister) {
        Result<String> result = new Result<String>();
        try {
            registerInfoService.deleteBystuRegister(stuRegister);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }



}
