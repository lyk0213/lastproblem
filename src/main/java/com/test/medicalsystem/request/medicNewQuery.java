package com.test.medicalsystem.request;
/*
对药物信息进行列表查询
 */
public class medicNewQuery {
    private String medicNum;
    private String medicName;
    private Integer page = 1;//当前页
    private  Integer limit = 10;//初始默认每页显示10条数据

    @Override
    public String toString() {
        return "medicNewQuery{" +
                "medicNum='" + medicNum + '\'' +
                ", medicName='" + medicName + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
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
