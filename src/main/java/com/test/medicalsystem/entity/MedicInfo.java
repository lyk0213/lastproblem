package com.test.medicalsystem.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
//import org.springframework.format.annotation.DateTimeFormat;

public class MedicInfo implements Serializable {
    private Integer mid;
    private String medName;
    private Double inPrice;
    private Double outPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private Integer medNum;
    private String medFunction;
    private String qualityTime;
    private Integer typeId;
    private String imgName;

    private static final long serialVersionUID = 1L;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public Double getInPrice() {
        return inPrice;
    }

    public void setInPrice(Double inPrice) {
        this.inPrice = inPrice;
    }

    public Double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(Double outPrice) {
        this.outPrice = outPrice;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getMedNum() {
        return medNum;
    }

    public void setMedNum(Integer medNum) {
        this.medNum = medNum;
    }

    public String getMedFunction() {
        return medFunction;
    }

    public void setMedFunction(String medFunction) {
        this.medFunction = medFunction;
    }

    public String getQualityTime() {
        return qualityTime;
    }

    public void setQualityTime(String qualityTime) {
        this.qualityTime = qualityTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "MedicInfo{" +
                "mid=" + mid +
                ", medName='" + medName + '\'' +
                ", inPrice=" + inPrice +
                ", outPrice=" + outPrice +
                ", publishDate=" + publishDate +
                ", medNum=" + medNum +
                ", medFunction='" + medFunction + '\'' +
                ", qualityTime='" + qualityTime + '\'' +
                ", typeId=" + typeId +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
