package com.test.medicalsystem.entity;
import java.io.Serializable;
public class AdminInfo implements Serializable{

    private Integer aid;
    private String adminNum;
    private String adminName;
    private String adminPwd;
    private String adminType;

    @Override
    public String toString() {
        return "AdminInfo{" +
                "aid=" + aid +
                ", adminNum='" + adminNum + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminType='" + adminType + '\'' +
                '}';
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(String adminNum) {
        this.adminNum = adminNum;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

}
