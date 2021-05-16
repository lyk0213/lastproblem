package com.test.medicalsystem.request;
/*
医生处方表分页查询
 */
public class DrugListQuery {
    private String stuRegister;//通过病历单进行查询
    private String stuNum;//通过学生学号
    private String payType;//支付状态进行查询
    private String payThing;//未定随机
    private Integer page = 1;//当前页
    private  Integer limit = 10;//初始默认每页显示10条数据


    @Override
    public String toString() {
        return "DrugListQuery{" +
                "stuRegister='" + stuRegister + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", payType='" + payType + '\'' +
                ", payThing='" + payThing + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuRegister() {
        return stuRegister;
    }

    public void setStuRegister(String stuRegister) {
        this.stuRegister = stuRegister;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayThing() {
        return payThing;
    }

    public void setPayThing(String payThing) {
        this.payThing = payThing;
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
