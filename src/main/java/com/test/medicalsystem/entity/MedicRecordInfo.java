package com.test.medicalsystem.entity;

import java.io.Serializable;

public class MedicRecordInfo implements Serializable{
    /*
    病例信息表
     */

    private Integer bid;
    private String stuRegister;
    private String stuNum;
    private String stuName;
    private String diagnosticResults;
    private String diagnosticTime;
    private String suggestion;

    @Override
    public String toString() {
        return "MedicRecordInfo{" +
                "bid=" + bid +
                ", stuRegister='" + stuRegister + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", diagnosticResults='" + diagnosticResults + '\'' +
                ", diagnosticTime='" + diagnosticTime + '\'' +
                ", suggestion='" + suggestion + '\'' +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getStuRegister() {
        return stuRegister;
    }

    public void setStuRegister(String stuRegister) {
        this.stuRegister = stuRegister;
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

    public String getDiagnosticTime() {
        return diagnosticTime;
    }

    public void setDiagnosticTime(String diagnosticTime) {
        this.diagnosticTime = diagnosticTime;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
