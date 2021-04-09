package com.test.medicalsystem.entity;
import java.io.Serializable;
public class StuInfo implements Serializable{
    private Integer sid;
    private String stuNum;
    private String stuName;
    private String stuPwd;
    private String stuType;

    private String stuSex;
    private String stuBirth;
    private String stuTelephone;
    private String stuAllergy;
    private String stuInsure;

    @Override
    public String toString() {
        return "StuInfo{" +
                "sid=" + sid +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuType='" + stuType + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuBirth='" + stuBirth + '\'' +
                ", stuTelephone='" + stuTelephone + '\'' +
                ", stuAllergy='" + stuAllergy + '\'' +
                ", stuInsure='" + stuInsure + '\'' +
                '}';
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuBirth() {
        return stuBirth;
    }

    public void setStuBirth(String stuBirth) {
        this.stuBirth = stuBirth;
    }

    public String getStuTelephone() {
        return stuTelephone;
    }

    public void setStuTelephone(String stuTelephone) {
        this.stuTelephone = stuTelephone;
    }

    public String getStuAllergy() {
        return stuAllergy;
    }

    public void setStuAllergy(String stuAllergy) {
        this.stuAllergy = stuAllergy;
    }

    public String getStuInsure() {
        return stuInsure;
    }

    public void setStuInsure(String stuInsure) {
        this.stuInsure = stuInsure;
    }


    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

}
