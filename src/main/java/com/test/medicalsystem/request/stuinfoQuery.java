package com.test.medicalsystem.request;

/**
 * 学生信息分页查询
 */

public class stuinfoQuery {
    private String stuName;
    private String stuNum;
    private Integer page = 1;//当前页
    private  Integer limit = 10;//初始默认每页显示10条数据

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
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
        return "stuinfoQuery{" +
                "stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
