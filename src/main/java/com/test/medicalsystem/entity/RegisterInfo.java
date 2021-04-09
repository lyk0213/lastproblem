package com.test.medicalsystem.entity;

import java.io.Serializable;
//import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class RegisterInfo implements Serializable {
    private Integer rid;
    private String stuNum;
    private String stuName;
    private String stuRegister;
    private String illType;
    //    @JsonFormat(pattern = "yyyy-MM-dd")
    private String illDate;
    private String treatmentType;

    public void setIllDate(String illDate) {
        this.illDate = illDate;
    }



    @Override
    public String toString() {
        return "RegisterInfo{" +
                "rid=" + rid +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuRegister='" + stuRegister + '\'' +
                ", illType='" + illType + '\'' +
                ", illDate='" + illDate + '\'' +
                ", treatmentType='" + treatmentType + '\'' +
                '}';
    }

    public String getIllDate() {
        return illDate;
    }




    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public String getStuRegister() {
        return stuRegister;
    }

    public void setStuRegister(String stuRegister) {
        this.stuRegister = stuRegister;
    }

    public String getIllType() {
        return illType;
    }

    public void setIllType(String illType) {
        this.illType = illType;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

}
