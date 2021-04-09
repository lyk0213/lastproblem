package com.test.medicalsystem.entity;
import java.io.Serializable;
public class DocInfo implements  Serializable{
    private Integer did;
    private String docNum;
    private String docName;
    private String docPwd;
    private String docType;

    private String docSex;
    private String docTelephone;
    private String docWorktime;
    private String docLevel;
    private String docPosition;


    @Override
    public String toString() {
        return "DocInfo{" +
                "did=" + did +
                ", docNum='" + docNum + '\'' +
                ", docName='" + docName + '\'' +
                ", docPwd='" + docPwd + '\'' +
                ", docType='" + docType + '\'' +
                ", docSex='" + docSex + '\'' +
                ", docTelephone='" + docTelephone + '\'' +
                ", docWorktime='" + docWorktime + '\'' +
                ", docLevel='" + docLevel + '\'' +
                ", docPosition='" + docPosition + '\'' +
                '}';
    }


    public String getDocSex() {
        return docSex;
    }

    public void setDocSex(String docSex) {
        this.docSex = docSex;
    }

    public String getDocTelephone() {
        return docTelephone;
    }

    public void setDocTelephone(String docTelephone) {
        this.docTelephone = docTelephone;
    }

    public String getDocWorktime() {
        return docWorktime;
    }

    public void setDocWorktime(String docWorktime) {
        this.docWorktime = docWorktime;
    }

    public String getDocLevel() {
        return docLevel;
    }

    public void setDocLevel(String docLevel) {
        this.docLevel = docLevel;
    }

    public String getDocPosition() {
        return docPosition;
    }

    public void setDocPosition(String docPosition) {
        this.docPosition = docPosition;
    }


    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
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

    public String getDocPwd() {
        return docPwd;
    }

    public void setDocPwd(String docPwd) {
        this.docPwd = docPwd;
    }

}
