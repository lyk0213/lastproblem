package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;

import com.test.medicalsystem.entity.DocInfo;
import com.test.medicalsystem.entity.PrescriptionInfo;
import com.test.medicalsystem.request.RegisterQuery;
import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.service.PrescriptionInfoService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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

    @Autowired
    private PrescriptionInfoService prescriptionInfoService;

    @RequestMapping(value = "/insertRegister")
    public Result<String> insertRegister(RegisterInfo registerInfo, HttpSession session) {
        Result<String> result = new Result<String>();
        try {
            String a = UUID.randomUUID().toString();
            String stuNum = registerInfo.getStuNum();
            String illDate = registerInfo.getIllDate();
            RegisterInfo re1 = registerInfoService.selectBytimeandNum(stuNum, illDate);
//            String stuRegister1 =re1.getStuRegister();//存在就有挂号的id，没有就位=为空
//            StringUtils.isBlank(stuRegister1)
            if (ObjectUtils.isEmpty(re1)) {
                registerInfo.setTreatmentType("0");//添加当前挂号状态，0为为挂号，1为已挂号，2为已就诊
                registerInfo.setStuRegister(a);
                registerInfoService.insertRegisterinfo(registerInfo);
                result.setData("添加成功");
                result.setMsg("挂号成功");
            } else {
//                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("当日已挂号");
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //需要修改当前的学生挂号单子表，并且将其进行修改就诊状态

    @RequestMapping(value = "/insertRegister1")
    public Result<String> insertRegister1(RegisterInfo registerInfo, HttpSession session) {
        Result<String> result = new Result<String>();
        try {
            String a = UUID.randomUUID().toString();
            String stuNum = registerInfo.getStuNum();
            String illDate = registerInfo.getIllDate();
            RegisterInfo re1 = registerInfoService.selectBytimeandNum(stuNum, illDate);
//            String stuRegister1 =re1.getStuRegister();//存在就有挂号的id，没有就位=为空
//            StringUtils.isBlank(stuRegister1)
            if (ObjectUtils.isEmpty(re1)) {
                registerInfo.setTreatmentType("1");//添加当前挂号状态，0为为挂号，1为已挂号，2为已就诊
                registerInfo.setStuRegister(a);
                registerInfoService.insertRegisterinfo(registerInfo);
                result.setData("添加成功");
                result.setMsg("挂号成功");
            } else {
//                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("当日已挂号");
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    /*
    学生查询自己当前的挂号单子
     */
    @RequestMapping(value = "/query")
    public PageResult<List<RegisterInfo>> selectByQueryCondition(RegisterQuery query) {
        int page = query.getPage();
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        try {

            System.out.println(query);
            result = registerInfoService.selectByQueryCondition(query);
            result.setPage(page);
            if (result.getData() == null) {
                result.setCode(ConfigUtil.ERROR_CODE);
                result.setMsg("未找到任何数据");
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
            result.setCode(ConfigUtil.SUCCESS_CODE);
//            result.setMsg();
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    /*
    医生查询全部挂号的语句
     */
    @RequestMapping(value = "/docquery")
    public PageResult<List<RegisterInfo>> docselectAll(RegisterQuery query) {
        int page = query.getPage();
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        try {
            System.out.println(query);
            result = registerInfoService.selectAllForDoc(query);
            result.setPage(page);
            if (result.getData() == null) {
                result.setCode(ConfigUtil.ERROR_CODE);
                result.setMsg("未找到任何数据");
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 医生查询学生挂号信息,医生调用信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/queryNovisit")
    public PageResult<List<RegisterInfo>> queryNovisit(RegisterQuery query,HttpSession session){
        int page = query.getPage();
        PageResult<List<RegisterInfo>> result = new PageResult<List<RegisterInfo>>();
        try {
            //对当前医生账号的session进行查询是否登录有效
            DocInfo docInfo = (DocInfo) session.getAttribute("docInfo");
            int did = 0;
            if (docInfo != null) {
                did = docInfo.getDid();
            } else {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("登录失效，请重新登录");
                result.setData(null);
                return result;
            }
            //输入查询，查出非2（已就诊的学生）
            query.setTreatmentType("2");
            result = registerInfoService.selectAllForDoc(query);
            result.setPage(page);
            if (result.getData() == null) {
                result.setCode(ConfigUtil.ERROR_CODE);
                result.setMsg("未找到任何数据");
            }
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/quepreinfo")
    public Result<PrescriptionInfo> quePreInfo(String stuRegister){
        Result<PrescriptionInfo> result = new Result<PrescriptionInfo>();
        try {
            PrescriptionInfo prescriptionInfo = prescriptionInfoService.selectBystuRegister(stuRegister);
            if (ObjectUtils.isEmpty(prescriptionInfo)) {
                result.setMsg("暂无挂号信息");
                result.setCode(ConfigUtil.FAILED_CODE);//1
                return result;
            }else {
                result.setMsg("请详细观看医嘱");
                result.setCode(ConfigUtil.SUCCESS_CODE);//0
                result.setData(prescriptionInfo);
                return result;
            }
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/updateRegister")
    public Result<String> updateRegister(RegisterInfo registerInfo){
        Result<String> result = new Result<String>();
        try{
            registerInfo.setTreatmentType("1");
            registerInfoService.updateRegisterInfoByNum(registerInfo);
            result.setMsg("修改成功");
            result.setCode(ConfigUtil.SUCCESS_CODE);

        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/queryByStr")
    public Result<RegisterInfo> selectBystuRegister(String stuRegister){
        Result<RegisterInfo> result = new Result<RegisterInfo>();
        try {
            RegisterInfo registerInfo = registerInfoService.selectBystuRegister(stuRegister);
            if (registerInfo == null){
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到信息");
                return  result;
            }
            result.setCode(ConfigUtil.SUCCESS_CODE);
            result.setMsg("学生信息如下");
            result.setData(registerInfo);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }



}
