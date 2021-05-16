package com.test.medicalsystem.request;

/**
 * 挂号记录查询
 */
public class RegisterQuery {
    private String illDate;
    private String stuNum;
    private String treatmentType;
    private Integer page = 1;//当前页
    private  Integer limit = 10;//初始默认每页显示10条数据

    @Override
    public String toString() {
        return "RegisterQuery{" +
                "illDate='" + illDate + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", treatmentType='" + treatmentType + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getIllDate() {
        return illDate;
    }

    public void setIllDate(String illDate) {
        this.illDate = illDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
