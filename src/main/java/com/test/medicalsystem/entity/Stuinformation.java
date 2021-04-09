package com.test.medicalsystem.entity;
import java.io.Serializable;
//不用了
public class Stuinformation implements Serializable{

    private String stuid;
    private String stuname;
    private String stusex;
    private String stuage;
    private String stucollege;
    private String stubirth;
    private String stucall;
    private String stutype;

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid== null ? null : stuid.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname== null ? null : stuname.trim();
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }

    public String getStucollege() {
        return stucollege;
    }

    public void setStucollege(String stucollege) {
        this.stucollege = stucollege;
    }

    public String getStubirth() {
        return stubirth;
    }

    public void setStubirth(String stubirth) {
        this.stubirth = stubirth;
    }

    public String getStucall() {
        return stucall;
    }

    public void setStucall(String stucall) {
        this.stucall = stucall;
    }

    public String getStutype() {
        return stutype;
    }

    public void setStutype(String stutype) {
        this.stutype = stutype;
    }

    @Override
    public String toString() {
        return "stuinformation{" +
                "stuid='" + stuid + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stusex='" + stusex + '\'' +
                ", stuage='" + stuage + '\'' +
                ", stucollege='" + stucollege + '\'' +
                ", stubirth='" + stubirth + '\'' +
                ", stucall='" + stucall + '\'' +
                ", stutype='" + stutype + '\'' +
                '}';
    }
}
