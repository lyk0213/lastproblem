package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.StuInfoService;

@RestController
@RequestMapping("/stuinfo")
public class StuinfoController {
    @Autowired
    private StuInfoService stuInfoService;

    @RequestMapping(value = "/selectBystuNum")
    public Result<StuInfo> selectBystuNum(String stuNum) {
        Result<StuInfo> result = new Result<StuInfo>();
        try {
            StuInfo stuInfo = stuInfoService.selectBystuNum(stuNum);
            if (stuInfo == null){
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该学生");
                return result;
            }
            result.setData(stuInfo);
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //修改学生信息
    @RequestMapping(value = "/updateStuinfoBystuNum")
    public Result<String> updateStuinfoBystuNum(StuInfo stuInfo){
        if ("".equals(stuInfo.getStuPwd())){
            stuInfo.setStuPwd(null);
        }
        System.out.println("修改信息"+stuInfo);
        Result<String> result = new Result<String>();
        try {
            stuInfoService.updateStuinfoBystuNum(stuInfo);
            result.setData("修改成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //增加学生信息
    @RequestMapping(value = "/insertStuInfo")
    public Result<String> insertStuInfo(StuInfo stuInfo,HttpSession session){
        Result<String> result = new Result<String>();
        try {
            //在登录中Type一定要为2才能登录进账户
            //在添加用户中，存在保存可能重复用户名的状况，建议进行查找是否唯一，sid是不断逐渐增加的
//            AdminInfo admin = (AdminInfo) session.getAttribute("admin");
//            int aid = 0;
//            if(admin!=null) {
//                aid = admin.getAid();
//            }else {
//                result.setCode(ConfigUtil.FAILED_CODE);
//                result.setMsg("登录失效，请重新登录");
//                result.setData(null);
//                return result;
//            }做管理员是否登录的判断选项
            stuInfo.setStuType("2");
            stuInfoService.insertStuInfo(stuInfo);
            result.setData("添加成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/deleteBystuNum")
    public Result<String> deleteBystuNum(String stuNum){
        Result<String> result = new Result<String>();
        try {
            stuInfoService.deleteBystuNum(stuNum);
            result.setData("删除成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }





}
