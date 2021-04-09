package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.LoginIndex;
import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.LoginIndexService;


@RestController
@RequestMapping("/login")
public class LoginIndexController {
    @Autowired
    private LoginIndexService loginIndexService;

    /**
     * 登录
     * @param userid
     * @param userpwd
     * @param session
     * @return
     */
    @RequestMapping(value = "loginuser",method = RequestMethod.POST)
    public Result<LoginIndex> userLogin(String userid,String userpwd,HttpSession session){
        Result<LoginIndex> result = new Result<LoginIndex>();
        try {
            LoginIndex useradmin =loginIndexService.loginall(userid, userpwd);
            if (useradmin==null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("用户名或密码错误，请重试");
            }
            session.setAttribute("useradmin", useradmin);
            result.setData(useradmin);

        } catch (Exception e) {
            // TODO: handle exception
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();//命令行中打印出错日志
        }
        return result;
    }

    /**
     * @Description注销
     * @param
     * @return
     */
    @RequestMapping(value = "logout")
    public Result<String> logout(HttpSession session){
        Result<String> result = new Result<String>();
        try {
            LoginIndex useradmin = (LoginIndex) session.getAttribute("useradmin");
            if (useradmin!=null){
                session.removeAttribute("useradmin");
            }
            result.setData("注销成功");
        } catch (Exception e){
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return  result;
    }




}
