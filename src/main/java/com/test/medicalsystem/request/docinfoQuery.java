package com.test.medicalsystem.request;
/*
医生信息分页查找
 */
public class docinfoQuery {
    private String docName;
    private String docNum;
    private Integer page = 1;//当前页
    private  Integer limit = 10;//初始默认每页显示10条数据

    @Override
    public String toString() {
        return "docinfoQuery{" +
                "docName='" + docName + '\'' +
                ", docNum='" + docNum + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
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
