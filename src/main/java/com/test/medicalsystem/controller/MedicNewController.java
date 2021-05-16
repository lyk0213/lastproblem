package com.test.medicalsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.medicalsystem.config.ConfigUtil;
import com.test.medicalsystem.entity.MedicNewsInfo;
import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.MedicNewsInfoService;

@RestController
@RequestMapping("/medicNews")
public class MedicNewController {
    @Autowired
    private MedicNewsInfoService medicNewsInfoService;

    /**
     * 返回药物列表
     * @return
     */
    @RequestMapping(value = "list")
    public Result<List<MedicNewsInfo>> selectMedicType(){
        Result<List<MedicNewsInfo>> result = new Result<List<MedicNewsInfo>>();
        try {
            List<MedicNewsInfo> list = medicNewsInfoService.selectAll();
            if (list.isEmpty()){
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到任何数据");
            }
            result.setData(list);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

}
