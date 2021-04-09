package com.test.medicalsystem.request;

import java.util.Date;

/**
 * 药品查询条件
 * @author lu97940467
 *
 */
public class MedicQuery {
    private String medName;
    private Date   publishDate1;
    private Date   publishDate2;
    private Integer page = 1;//当前页
    private  Integer limit = 10;//初始默认每页显示10条数据

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public Date getPublishDate1() {
        return publishDate1;
    }

    public void setPublishDate1(Date publishDate1) {
        this.publishDate1 = publishDate1;
    }

    public Date getPublishDate2() {
        return publishDate2;
    }

    public void setPublishDate2(Date publishDate2) {
        this.publishDate2 = publishDate2;
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

    @Override
    public String toString() {
        return "MedicQuery{" +
                "medName='" + medName + '\'' +
                ", publishDate1=" + publishDate1 +
                ", publishDate2=" + publishDate2 +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
