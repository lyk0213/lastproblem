package com.test.medicalsystem.entity;

import java.io.Serializable;

public class LoginIndex implements  Serializable{

    private String userid;

    private String userpwd;

    private String userno;

    public String getUserid() {
        return userid;
    }
    //去除空格
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    @Override
    public String toString() {
        return "LoginIndex [userid=" + userid + ", userpwd=" + userpwd + ", userno=" + userno + "]";
    }



}
