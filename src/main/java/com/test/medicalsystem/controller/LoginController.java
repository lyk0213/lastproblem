package com.test.medicalsystem.controller;
import javax.servlet.http.HttpSession;

import com.test.medicalsystem.entity.DocInfo;
import com.test.medicalsystem.entity.StuInfo;
import com.test.medicalsystem.service.DocInfoService;
import com.test.medicalsystem.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.AdminInfo;
import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.result.ResultLogin;
import com.test.medicalsystem.service.AdminInfoService;


@RestController
@RequestMapping("/logintosystem")
public class LoginController {
    @Autowired
    private AdminInfoService adminInfoService;

    @Autowired
    private DocInfoService docInfoService;

    @Autowired
    private StuInfoService stuInfoService;

    @RequestMapping(value = "loginto", method = RequestMethod.POST)
    public Result<AdminInfo> UserLogin(String userNum, String userPwd, HttpSession session) {
        Result<AdminInfo> result = new Result<AdminInfo>();
        try {
            AdminInfo adminInfo = adminInfoService.loginAdmin(userNum, userPwd);
            if (adminInfo == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("用户名或者密码错误");
            }
            result.setCode(ConfigUtil.SUCCESS_CODE);
            session.setAttribute("adminInfo", adminInfo);
            result.setData(adminInfo);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

//管理员0，医务室老师1，学生2
    @RequestMapping(value = "loginin", method = RequestMethod.POST)
    public Result<?> userLoginin(String userNum, String userPwd, String userno, HttpSession session) {
        Result<?> result = new Result<Object>();
      //  String type1 = new String(userno);
        System.out.println(userno);
        try {
            if (userno.equals("0")) {
                //管理员
                Result<AdminInfo> result1 = new Result<AdminInfo>();
                AdminInfo adminInfo = adminInfoService.loginAdmin(userNum, userPwd);
                if (adminInfo == null) {
                    result1.setCode(ConfigUtil.FAILED_CODE);
                    result1.setMsg("用户名或者密码错误");
                }
                result1.setCode(ConfigUtil.SUCCESS_CODE);
                session.setAttribute("adminInfo", adminInfo);
                //传入session
                result1.setData(adminInfo);
                return result1;
            } else if (userno.equals("1")) {
                //医生
                Result<DocInfo> result2 = new Result<DocInfo>();
                DocInfo docInfo = docInfoService.loginDoc(userNum ,userPwd);
                if (docInfo == null) {
                    result2.setCode(ConfigUtil.FAILED_CODE);
                    result2.setMsg("用户名或者密码错误");
                }result2.setCode(ConfigUtil.SUCCESS_CODE);
                session.setAttribute("docInfo", docInfo);
                //传入session
                result2.setData(docInfo);
                return result2;

            } else if (userno.equals("2")) {
                //学生
                Result<StuInfo> result3 = new Result<StuInfo>();
                StuInfo stuInfo =stuInfoService.loginStu(userNum,userPwd);
                if (stuInfo == null) {
                    result3.setCode(ConfigUtil.FAILED_CODE);
                    result3.setMsg("用户名或者密码错误");
                }
                result3.setCode(ConfigUtil.SUCCESS_CODE);
                session.setAttribute("stuInfo", stuInfo);
                //传入session
                result3.setData(stuInfo);
                return result3;
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 学生注销
     * @param session
     * @return
     */
    @RequestMapping(value = "stulogout")
    public Result<String> logoutstu(HttpSession session){
        Result<String> result = new Result<String>();
        try{
            StuInfo stuInfo =(StuInfo) session.getAttribute("stuInfo");
            if (stuInfo!=null) {
                session.removeAttribute("stuInfo");
            }result.setData("注销成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "doclogout")
    public Result<String> logoutdoc(HttpSession session){
        Result<String> result = new Result<String>();
        try{
            DocInfo docInfo  =(DocInfo) session.getAttribute("docInfo");
            if (docInfo!=null) {
                session.removeAttribute("docInfo");
            }result.setData("注销成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "adminlogout")
    public Result<String> logoutadmin(HttpSession session){
        Result<String> result = new Result<String>();
        try{
            AdminInfo adminInfo   =(AdminInfo) session.getAttribute("adminInfo");
            if (adminInfo!=null) {
                session.removeAttribute("adminInfo");
            }result.setData("注销成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }


}
