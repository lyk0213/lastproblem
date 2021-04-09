package com.test.medicalsystem.controller;
import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.LoginIndex;
import com.test.medicalsystem.entity.MedicInfo;
import com.test.medicalsystem.request.MedicQuery;
import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/medic")
public class MedicController {

    @Autowired
    private MedicService medicService;
//查找，模糊查找+时间排查查找（完成）
    @RequestMapping(value = "/query")
    public PageResult<List<MedicInfo>> selectByQueryCondition(MedicQuery query,String date1, String date2) {
        int page = query.getPage();
        PageResult<List<MedicInfo>> result = new PageResult<List<MedicInfo>>();
        try {
            if (date1!=null&&!"".equals(date1)){
                query.setPublishDate1(ConfigUtil.sdf.parse(date1));
            }
            if (date2!=null&&!"".equals(date2)){
                query.setPublishDate2(ConfigUtil.sdf.parse(date2));
            }
            System.out.println(query+","+date1+","+date2);
            result =medicService.selectByQueryCondition(query);
            result.setPage(page);
            if (result.getData() == null){
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

    //添加药物
    @RequestMapping(value = "/add")
    public Result<String> addMedic(MedicInfo medic,HttpSession session,String publishDate){
        Result<String> result =new Result<String>();
        try {
            LoginIndex useradmin =(LoginIndex) session.getAttribute("useradmin");
            String userid = null;
            if (useradmin!=null){
                userid = useradmin.getUserid();
            }else {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("登录失效，请重新登录");
                result.setData(null);
                return result;
            }
//            medic.setTypeId(0);
//            System.out.println("增加到上架状态"+publishDate);
//            medic.setPublishDate(ConfigUtil.sdf.parse(publishDate));
//            System.out.println("增加时间");
//            medicService.insertSelective(medic);
            medic.setTypeId(0);
//            medic.setPublishDate(ConfigUtil.sdf.parse(publishDate));
            medic.setPublishDate(new Date());
            medicService.insertSelective(medic);
            result.setData("添加成功");
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //下架药品列表
    @RequestMapping(value = "downList")
    public Result<List<MedicInfo>> selectDownList(){
        Result<List<MedicInfo>> result = new Result<List<MedicInfo>>();
        try {
            List<MedicInfo> list = medicService.selectDownMedic();
            result.setData(list);
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //重新上架
    @RequestMapping(value = "/up")
    public Result<String> upMedic(Integer mid){
        Result<String> result = new Result<String>();
        try {
            medicService.upAgainMedic(mid);
            result.setData("上架成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
    //通过id查询书籍信息
    @RequestMapping(value = "/one")
    public Result<MedicInfo> selectById(Integer mid){
        Result<MedicInfo> result = new Result<MedicInfo>();
        try {
            MedicInfo m =medicService.selectByPrimaryKey(mid);
            if(m==null){
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该资源");
            }
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //修改图书
    @RequestMapping(value = "/update")
    public  Result<String> updateMedic(MedicInfo medic, String publishDate1){
        Result<String> result =new Result<String>();
        try {
            medic.setImgName(medic.getImgName().substring(medic.getImgName().lastIndexOf("/")+1));
            System.out.println("修改成功"+medic);
            medicService.updateMedic(medic);
            result.setMsg("未找到该资源");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }



    //下架药品（完成）
    @RequestMapping(value = "/down")
    public  Result<String> downMedic(Integer mid){
        Result<String> result = new Result<String>();
        try{
            medicService.downMedic(mid);
            result.setData("下架成功");
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //图片封面上传(可能完成)
    @RequestMapping(value = "/imageName")
    public Result<String> selectImgName(MultipartFile file){
        Result<String> result = new Result<String>();
        try{
            String newFileName = ConfigUtil.fileOperate(file,ConfigUtil.IMG_LOCAL_PATH);
            result.setData(newFileName);
        }catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }




}