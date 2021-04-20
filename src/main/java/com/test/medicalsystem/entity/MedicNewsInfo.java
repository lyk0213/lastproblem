package com.test.medicalsystem.entity;
import java.io.Serializable;

public class MedicNewsInfo implements Serializable{

    /*
    药物信息表
     */

    private Integer mid;
    private String medicNum;
    private String medicName;
    private Integer medicAmount;
    private Double medicPrice;
    private String medicRatio;
    private String medicUse;
    private String medicBan;
    private String medicType;

    @Override
    public String toString() {
        return "MedicNewsInfo{" +
                "mid=" + mid +
                ", medicNum='" + medicNum + '\'' +
                ", medicName='" + medicName + '\'' +
                ", medicAmount=" + medicAmount +
                ", medicPrice=" + medicPrice +
                ", medicRatio='" + medicRatio + '\'' +
                ", medicUse='" + medicUse + '\'' +
                ", medicBan='" + medicBan + '\'' +
                ", medicType='" + medicType + '\'' +
                '}';
    }

    public String getMedicType() {
        return medicType;
    }

    public void setMedicType(String medicType) {
        this.medicType = medicType;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMedicNum() {
        return medicNum;
    }

    public void setMedicNum(String medicNum) {
        this.medicNum = medicNum;
    }

    public String getMedicName() {
        return medicName;
    }

    public void setMedicName(String medicName) {
        this.medicName = medicName;
    }

    public Integer getMedicAmount() {
        return medicAmount;
    }

    public void setMedicAmount(Integer medicAmount) {
        this.medicAmount = medicAmount;
    }

    public Double getMedicPrice() {
        return medicPrice;
    }

    public void setMedicPrice(Double medicPrice) {
        this.medicPrice = medicPrice;
    }

    public String getMedicRatio() {
        return medicRatio;
    }

    public void setMedicRatio(String medicRatio) {
        this.medicRatio = medicRatio;
    }

    public String getMedicUse() {
        return medicUse;
    }

    public void setMedicUse(String medicUse) {
        this.medicUse = medicUse;
    }

    public String getMedicBan() {
        return medicBan;
    }

    public void setMedicBan(String medicBan) {
        this.medicBan = medicBan;
    }
}
