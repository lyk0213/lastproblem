package com.test.medicalsystem.controller;

import javax.servlet.http.HttpSession;

import com.test.medicalsystem.result.PageResult;
import com.test.medicalsystem.request.DrugListQuery;


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
import com.test.medicalsystem.entity.PrescriptionInfo;
import com.test.medicalsystem.entity.DrugOut;
import com.test.medicalsystem.entity.MedicNewsInfo;

import com.test.medicalsystem.result.Result;
import com.test.medicalsystem.service.DocInfoService;
import com.test.medicalsystem.service.StuInfoService;
import com.test.medicalsystem.service.RegisterInfoService;
import com.test.medicalsystem.service.MedicRecordInfoService;
import com.test.medicalsystem.service.PrescriptionInfoService;
import com.test.medicalsystem.service.DrugOutService;
import com.test.medicalsystem.service.MedicNewsInfoService;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/docinfo")
public class DocinfoController {
    @Autowired
    private StuInfoService stuInfoService;

    @Autowired
    private DocInfoService docInfoService;

    @Autowired
    private RegisterInfoService registerInfoService;

    @Autowired
    private MedicRecordInfoService medicRecordInfoService;

    @Autowired
    private PrescriptionInfoService prescriptionInfoService;

    @Autowired
    private DrugOutService drugOutService;

    @Autowired
    private MedicNewsInfoService medicNewsInfoService;

    @RequestMapping(value = "/selectByDocNum")
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

    //获取病例单信息
    @RequestMapping(value = "/selectMeRecordBystuRegister")
    public Result<MedicRecordInfo> selectMeRecordBystuRegister(String stuRegister) {
        Result<MedicRecordInfo> result = new Result<MedicRecordInfo>();
        try {
            MedicRecordInfo medicRecordInfo = medicRecordInfoService.selectBystuRegister(stuRegister);
            if (medicRecordInfo == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找找到该病例单");
                return result;
            }
            result.setCode(ConfigUtil.SUCCESS_CODE);
            result.setData(medicRecordInfo);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //获取处方单信息
    @RequestMapping(value = "/selectPrecordBystuRegister")
    public Result<PrescriptionInfo> selectPrecordBystuRegister(String stuRegister) {
        Result<PrescriptionInfo> result = new Result<PrescriptionInfo>();
        try {
            PrescriptionInfo prescriptionInfo = prescriptionInfoService.selectBystuRegister(stuRegister);
            if (prescriptionInfo == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找找到该处方单");
                return result;
            }
            result.setCode(ConfigUtil.SUCCESS_CODE);
            result.setData(prescriptionInfo);
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

    //修改病例单信息
    @RequestMapping(value = "/updateMedicRecord")
    public Result<String> updateMedicRecord(MedicRecordInfo medicRecordInfo) {
        Result<String> result = new Result<String>();
        try {
            medicRecordInfoService.updateMedicRecordInfoBystuRegister(medicRecordInfo);
            result.setMsg("修改成功");
            result.setCode(ConfigUtil.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //修改药物单信息
    @RequestMapping(value = "/updatePrecord")
    public Result<String> updatePrecord(PrescriptionInfo prescriptionInfo) {
        Result<String> result = new Result<String>();
        try {
            prescriptionInfoService.updatePrescriptionInfoBystuRegister(prescriptionInfo);
            result.setMsg("修改成功");
            result.setCode(ConfigUtil.SUCCESS_CODE);
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

    //删除医生信息通过DocNum
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

    //通过病历单号码查找到当前病历单的内容
    @RequestMapping(value = "/selectBystuRegister")
    public Result<RegisterInfo> selectBystuRegister(String stuRegister) {
        Result<RegisterInfo> result = new Result<RegisterInfo>();
        try {
            RegisterInfo a = registerInfoService.selectBystuRegister(stuRegister);
            if (a == null) {
                result.setCode(ConfigUtil.FAILED_CODE);
                result.setMsg("未找到该资源");
            }
            result.setData(a);
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }


    //点击添加学生病例单
    @RequestMapping(value = "addMedicRecord")
    public Result<String> addMedicRecord(MedicRecordInfo medicRecordInfo, HttpSession session) {
        Result<String> result = new Result<String>();
        try {
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

            String stuRegister = medicRecordInfo.getStuRegister();

            if (medicRecordInfoService.selectBystuRegister(stuRegister) == null) {
                medicRecordInfoService.insertMedicRecordInfo(medicRecordInfo);
                RegisterInfo a = new RegisterInfo();
                a.setTreatmentType("1");
                registerInfoService.updateRegisterInfoByNum(a);
                result.setMsg("增加药物单成功");
                result.setCode(ConfigUtil.SUCCESS_CODE);
            } else {
                result.setMsg("已存在病例单");
                result.setCode(ConfigUtil.FAILED_ADD_CODE);
            }

        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //点击添加处方单信息
    @RequestMapping(value = "/addPrescription")
    public Result<String> addPrescription(PrescriptionInfo prescriptionInfo, HttpSession session) {
        Result<String> result = new Result<String>();
        try {
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
            //增加病例诊断结果
            String a = prescriptionInfo.getStuRegister();
            if (prescriptionInfoService.selectBystuRegister(a) == null) {
                MedicRecordInfo medicRecordInfo = medicRecordInfoService.selectBystuRegister(a);
                prescriptionInfo.setDiagnosticResults(medicRecordInfo.getDiagnosticResults());
                //我要获取当前的日期
                Date date = new Date();
                //设置要获取到什么样的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //获取String类型的时间
                String createdate = sdf.format(date);
                prescriptionInfo.setAdviceTime(createdate);
                prescriptionInfoService.insertPrescriptionInfo(prescriptionInfo);
                result.setMsg("增加处方单成功");
                result.setCode(ConfigUtil.SUCCESS_CODE);

                if (prescriptionInfo != null) {
                    DrugOut drugOut = new DrugOut();
                    drugOut.setStuRegister(prescriptionInfo.getStuRegister());

                    drugOut.setDocName(docInfo.getDocName());
                    drugOut.setDocNum(docInfo.getDocNum());

                    drugOut.setStuName(prescriptionInfo.getStuName());
                    drugOut.setStuNum(prescriptionInfo.getStuNum());
                    drugOut.setDiagnosticResults(prescriptionInfo.getMedicNews());

                    String stuNum = prescriptionInfo.getStuNum();
                    StuInfo s1 = stuInfoService.selectBystuNum(stuNum);
                    drugOut.setStuInsure(s1.getStuInsure());
                    drugOutService.insertDrugList(drugOut);
                }
            } else {
                result.setMsg("已存在处方单");
                result.setCode(ConfigUtil.FAILED_ADD_CODE);
            }
        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }

    //开药处理流程
    @RequestMapping(value = "/drugquery")
    public PageResult<List<DrugOut>> selectDrugInfo(DrugListQuery query) {
        int page = query.getPage();
        PageResult<List<DrugOut>> result = new PageResult<List<DrugOut>>();
        try {
            result = drugOutService.selectByQueryCondition(query);
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

    //提交信息
    @RequestMapping(value = "/updateDrugList")
    public Result<String> updateDrugList(DrugOut drugOut, HttpSession session) {
        Result<String> result = new Result<String>();
        try {
//            DocInfo docInfo =(DocInfo) session.getAttribute("docinfo");
//            int did = 0;
//            if (docInfo !=null){
//                did = docInfo.getDid();
//            }else {
//                result.setCode(ConfigUtil.FAILED_CODE);
//                result.setMsg("登录失效，请重新登录");
//                result.setData(null);
//                return result;
//            }
//            drugOut.setDocName(docInfo.getDocName());
//            drugOut.setDocNum(docInfo.getDocNum());

            MedicNewsInfo medicNewsInfo1 = medicNewsInfoService.selectBymedicName(drugOut.getMedicName1());
            int amount1 = drugOut.getMedicAmount1();
            double a1 = medicNewsInfo1.getMedicPrice();
            double s1 = amount1 * a1;

            MedicNewsInfo medicNewsInfo2 = medicNewsInfoService.selectBymedicName(drugOut.getMedicName2());
            int amount2 = drugOut.getMedicAmount2();
            double a2 = medicNewsInfo2.getMedicPrice();
            double s2 = amount2 * a2;

            MedicNewsInfo medicNewsInfo3 = medicNewsInfoService.selectBymedicName(drugOut.getMedicName3());
            int amount3 = drugOut.getMedicAmount3();
            double a3 = medicNewsInfo3.getMedicAmount();
            double s3 = amount3 * a3;

            double sum = s1 + s2 + s3;

            DrugOut drugOut1=drugOutService.selectBystuRegister(drugOut.getStuRegister());
            drugOut.setStuInsure(drugOut1.getStuInsure());


            if ("存在医保".equals(drugOut.getStuInsure())) {
                String ratio1 = medicNewsInfo1.getMedicRatio();
                String r1 = ratio1.substring(0, ratio1.length() - 1);
                double sr1 = Double.parseDouble(r1);
                double sum1 = s1 * sr1 / 100;

                String ratio2 = medicNewsInfo2.getMedicRatio();
                String r2 = ratio2.substring(0, ratio2.length() - 1);
                double sr2 = Double.parseDouble(r2);
                double sum2 = s2 * sr2 / 100;

                String ratio3 = medicNewsInfo3.getMedicRatio();
                String r3 = ratio3.substring(0, ratio3.length() - 1);
                double sr3 = Double.parseDouble(r3);
                double sum3 = s3 * sr3 / 100;

                double allSum = sum1 + sum2 + sum3;
                drugOut.setEndMoney(allSum);
            } else {
                drugOut.setEndMoney(sum);
            }


            drugOutService.updateDrugOutBystuRegister(drugOut);
            result.setMsg("修改成功");
            result.setCode(ConfigUtil.SUCCESS_CODE);

        } catch (Exception e) {
            result.setCode(ConfigUtil.ERROR_CODE);
            result.setMsg(ConfigUtil.ERROR_MSG);
            e.printStackTrace();
        }
        return result;
    }
}
