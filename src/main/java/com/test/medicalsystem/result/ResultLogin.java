package com.test.medicalsystem.result;
import com.test.medicalsystem.config.ConfigUtil;
public class ResultLogin<T> {
    private Integer code;
    private String msg;
    private Integer typ;
    private T data;

    public ResultLogin(){
        this.code = ConfigUtil.SUCCESS_CODE;
        this.msg = ConfigUtil.SUCCESS_MSG;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTyp() {
        return typ;
    }

    public void setTyp(Integer typ) {
        this.typ = typ;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
