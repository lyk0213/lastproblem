package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.entity.AdminInfo;
import com.test.medicalsystem.entity.DocInfo;
import com.test.medicalsystem.entity.MedicNewsInfo;


import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.request.stuinfoQuery;
import com.test.medicalsystem.request.docinfoQuery;
import com.test.medicalsystem.request.medicNewQuery;
import com.test.medicalsystem.service.StuInfoService;
import com.test.medicalsystem.service.DocInfoService;
import com.test.medicalsystem.service.MedicNewsInfoService;
import com.test.medicalsystem.service.AdminInfoService;

import java.util.List;

@RestController
@RequestMapping("admincontroal")
public class ManagerController {
    @Autowired
    private StuInfoService stuInfoService;

    @Autowired
    private DocInfoService docInfoService;

    @Autowired
    private AdminInfoService adminInfoService;

    @Autowired
    private MedicNewsInfoService medicNewsInfoService;

    //管理员查询学生信息,返回查询的学生列
    @RequestMapping(value = "/querystulist")
    public PageResult<List<StuInfo>> selectByQueryCondition(stuinfoQuery query, String adminNum) {
        int page = query.getPage();
        PageResult<List<StuInfo>> result = new PageResult<List<StuInfo>>();
        try {
            AdminInfo adminInfo = adminInfoService.selectNews(adminNum);
            result = stuInfoService.selectByQueryCondition(query);
            result.setPage(page);
            if ("0".equals(adminInfo.getAdminType())) {
                if (result.getData() == null) {
                    result.setCode(ConfigUtil.ERROR_CODE);
                    result.setMsg("未找到任何数据");
                }
            } else {
                result.setCode(ConfigUtil.ERROR_CODE);
                result.setMsg("登录失效");
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //管理员查询医生信息，返回医生列表
    @RequestMapping(value = "querydoclist")
    public PageResult<List<DocInfo>> selectDocList(docinfoQuery query, String adminNum) {
        int page = query.getPage();
        PageResult<List<DocInfo>> result = new PageResult<List<DocInfo>>();
        try {
            AdminInfo adminInfo = adminInfoService.selectNews(adminNum);
            result = docInfoService.selectByQueryCondition(query);
            result.setPage(page);
            if ("0".equals(adminInfo.getAdminType())) {
                if (result.getData() == null) {
                    result.setCode(ConfigUtil.ERROR_CODE);
                    result.setMsg("未找到任何数据");
                }
            } else {
                result.setCode(ConfigUtil.ERROR_CODE);
                result.setMsg("登录失效");
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //管理员查询药物信息列表
    @RequestMapping(value = "queryMedicList")
    public PageResult<List<MedicNewsInfo>> selectMedicNews(medicNewQuery query, String adminNum) {
        int page = query.getPage();
        PageResult<List<MedicNewsInfo>> result = new PageResult<List<MedicNewsInfo>>();
        try {
            AdminInfo adminInfo = adminInfoService.selectNews(adminNum);
            result = medicNewsInfoService.selectByQueryCondition(query);
            result.setPage(page);
            if ("0".equals(adminInfo.getAdminType())) {
                if (result.getData() == null) {
                    result.setCode(ConfigUtil.ERROR_CODE);
                    result.setMsg("未找到任何数据");
                }
            } else {
                result.setCode(ConfigUtil.ERROR_CODE);
                result.setMsg("登录失效");
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //通过点击按钮返回数据获取学生信息
    @RequestMapping(value = "/selectBystuNum")
    public Result<StuInfo> selectBystuNum(String stuNum) {
        Result<StuInfo> result = new Result<StuInfo>();
        try {
            StuInfo stuInfo = stuInfoService.selectBystuNum(stuNum);
            if (stuInfo == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该学生");
                return result;
            }
            result.setData(stuInfo);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //通过点击按钮返回数据获取医生信息
    @RequestMapping(value = "selectByDocNum")
    public Result<DocInfo> selectByDocNum(String docNum) {
        Result<DocInfo> result = new Result<DocInfo>();
        try {
            DocInfo docInfo = docInfoService.selectBydocNum(docNum);
            if (docInfo == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该医生");
                return result;
            }
            result.setData(docInfo);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //通过点击按钮返回数据获取药物单个信息
    @RequestMapping(value = "selectBymedicNum")
    public Result<MedicNewsInfo> selectBymedicNum(String medicNum) {
        Result<MedicNewsInfo> result = new Result<MedicNewsInfo>();
        try {
            MedicNewsInfo medicNewsInfo = medicNewsInfoService.selectBymedicNum(medicNum);
            if (medicNewsInfo == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该药物信息");
                return result;
            }
            result.setData(medicNewsInfo);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //修改
    @RequestMapping(value = "/updateStuinfoBystuNum")
    public Result<String> updateStuinfoBystuNum(StuInfo stuInfo) {
        if ("".equals(stuInfo.getStuPwd())) {
            stuInfo.setStuPwd(null);
        }
        System.out.println("修改信息" + stuInfo);
        Result<String> result = new Result<String>();
        try {
            stuInfoService.updateStuinfoBystuNum(stuInfo);
            result.setData("修改成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //修改医生信息
    @RequestMapping(value = "/updateDocInfoBydocNum")
    public Result<String> updateDocInfoBydocNum(DocInfo docInfo) {
        if ("".equals(docInfo.getDocPwd())) {
            docInfo.setDocPwd(null);
        }
        System.out.println("修改信息" + docInfo);
        Result<String> result = new Result<String>();
        try {
            docInfoService.updateDocInfoBydocNum(docInfo);
            result.setData("修改成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //修改药物信息
    @RequestMapping(value = "/updateMedicNewsInfoBymedicNum")
    public Result<String> updateMedicNewsInfoBymedicNum(MedicNewsInfo medicNewsInfo){
        Result<String> result = new Result<String>();
        try {
            medicNewsInfoService.updateMedicNewsInfoBymedicNum(medicNewsInfo);
            result.setData("修改成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }


    //增加
    @RequestMapping(value = "/insertStuinfo")
    public Result<String> insertStuinfo(StuInfo stuInfo, HttpSession session) {
        Result<String> result = new Result<String>();
        try {

            stuInfo.setStuType("2");
            stuInfoService.insertStuInfo(stuInfo);
            result.setData("添加成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //增加医生信息
    @RequestMapping(value = "/insertDocInfo")
    public Result<String> insertDocInfo(DocInfo docInfo, HttpSession session) {
        Result<String> result = new Result<String>();
        try {
            docInfo.setDocType("1");
            docInfoService.insertDocInfo(docInfo);
            result.setData("添加成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //增加药物信息
    @RequestMapping(value = "/insertMedicNewsInfo")
    public Result<String> insertMedicNewsInfo(MedicNewsInfo medicNewsInfo,HttpSession session){
        Result<String> result = new Result<String>();
        try{
            medicNewsInfo.setMedicType("1");
            medicNewsInfoService.insertMedicNewsInfo(medicNewsInfo);
            result.setData("增加药物信息成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //删除
    @RequestMapping(value = "/deleteBystuNum")
    public Result<String> deleteBystuNum(String stuNum) {
        Result<String> result = new Result<String>();
        try {
            stuInfoService.deleteBystuNum(stuNum);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //删除医生的信息
    @RequestMapping(value = "/deleteBydocNum")
    public Result<String> deleteBydocNum(String docNum) {
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
    //删除药物信息
    @RequestMapping(value = "/deleteBymedicNum")
    public Result<String> deleteBymedicNum(String medicNum) {
        Result<String> result = new Result<String>();
        try {
            medicNewsInfoService.deleteBymedicNum(medicNum);
            result.setData("删除成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }



}
