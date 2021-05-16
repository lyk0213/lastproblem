package com.test.medicalsystem.entity;
import java.io.Serializable;
public class DrugOut implements Serializable{
    //21个
    private Integer zid;
    private String  stuRegister;
    private String  docNum;
    private String  docName;
    private String  stuNum;
    private String  stuName;
    private String  diagnosticResults;
    private String  medicNum1;
    private String  medicName1;
    private Integer  medicAmount1;
    private String  medicNum2;
    private String  medicName2;
    private Integer  medicAmount2;
    private String  medicNum3;
    private String  medicName3;
    private Integer  medicAmount3;
    private String  stuInsure;
    private Double  endMoney;
    private String  payType;
    private String  payTime;
    private String  payThing;

    @Override
    public String toString() {
        return "DrugOut{" +
                "zid=" + zid +
                ", stuRegister='" + stuRegister + '\'' +
                ", docNum='" + docNum + '\'' +
                ", docName='" + docName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", diagnosticResults='" + diagnosticResults + '\'' +
                ", medicNum1='" + medicNum1 + '\'' +
                ", medicName1='" + medicName1 + '\'' +
                ", medicAmount1=" + medicAmount1 +
                ", medicNum2='" + medicNum2 + '\'' +
                ", medicName2='" + medicName2 + '\'' +
                ", medicAmount2=" + medicAmount2 +
                ", medicNum3='" + medicNum3 + '\'' +
                ", medicName3='" + medicName3 + '\'' +
                ", medicAmount3=" + medicAmount3 +
                ", stuInsure='" + stuInsure + '\'' +
                ", endMoney=" + endMoney +
                ", payType='" + payType + '\'' +
                ", payTime='" + payTime + '\'' +
                ", payThing='" + payThing + '\'' +
                '}';
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getStuRegister() {
        return stuRegister;
    }

    public void setStuRegister(String stuRegister) {
        this.stuRegister = stuRegister;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getDiagnosticResults() {
        return diagnosticResults;
    }

    public void setDiagnosticResults(String diagnosticResults) {
        this.diagnosticResults = diagnosticResults;
    }

    public String getMedicNum1() {
        return medicNum1;
    }

    public void setMedicNum1(String medicNum1) {
        this.medicNum1 = medicNum1;
    }

    public String getMedicName1() {
        return medicName1;
    }

    public void setMedicName1(String medicName1) {
        this.medicName1 = medicName1;
    }

    public Integer getMedicAmount1() {
        return medicAmount1;
    }

    public void setMedicAmount1(Integer medicAmount1) {
        this.medicAmount1 = medicAmount1;
    }

    public String getMedicNum2() {
        return medicNum2;
    }

    public void setMedicNum2(String medicNum2) {
        this.medicNum2 = medicNum2;
    }

    public String getMedicName2() {
        return medicName2;
    }

    public void setMedicName2(String medicName2) {
        this.medicName2 = medicName2;
    }

    public Integer getMedicAmount2() {
        return medicAmount2;
    }

    public void setMedicAmount2(Integer medicAmount2) {
        this.medicAmount2 = medicAmount2;
    }

    public String getMedicNum3() {
        return medicNum3;
    }

    public void setMedicNum3(String medicNum3) {
        this.medicNum3 = medicNum3;
    }

    public String getMedicName3() {
        return medicName3;
    }

    public void setMedicName3(String medicName3) {
        this.medicName3 = medicName3;
    }

    public Integer getMedicAmount3() {
        return medicAmount3;
    }

    public void setMedicAmount3(Integer medicAmount3) {
        this.medicAmount3 = medicAmount3;
    }

    public String getStuInsure() {
        return stuInsure;
    }

    public void setStuInsure(String stuInsure) {
        this.stuInsure = stuInsure;
    }

    public Double getEndMoney() {
        return endMoney;
    }

    public void setEndMoney(Double endMoney) {
        this.endMoney = endMoney;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayThing() {
        return payThing;
    }

    public void setPayThing(String payThing) {
        this.payThing = payThing;
    }
}
