package com.test.medicalsystem.entity;

import java.io.Serializable;

public class PrescriptionInfo implements Serializable{
    /*
    处方信息表
     */
    private Integer pid;
    private String stuRegister;
    private String docNum;
    private String docName;
    private String stuNum;
    private String stuName;
    private String diagnosticResults;
    private String medicNews;
    private String medicWay;
    private Double medicMoney;
    private String adviceTime;

    @Override
    public String toString() {
        return "PrescriptionInfo{" +
                "pid=" + pid +
                ", stuRegister='" + stuRegister + '\'' +
                ", docNum='" + docNum + '\'' +
                ", docName='" + docName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", diagnosticResults='" + diagnosticResults + '\'' +
                ", medicNews='" + medicNews + '\'' +
                ", medicWay='" + medicWay + '\'' +
                ", medicMoney=" + medicMoney +
                ", adviceTime='" + adviceTime + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getMedicNews() {
        return medicNews;
    }

    public void setMedicNews(String medicNews) {
        this.medicNews = medicNews;
    }

    public String getMedicWay() {
        return medicWay;
    }

    public void setMedicWay(String medicWay) {
        this.medicWay = medicWay;
    }

    public Double getMedicMoney() {
        return medicMoney;
    }

    public void setMedicMoney(Double medicMoney) {
        this.medicMoney = medicMoney;
    }

    public String getAdviceTime() {
        return adviceTime;
    }

    public void setAdviceTime(String adviceTime) {
        this.adviceTime = adviceTime;
    }
}
