package com.example.srv.controller.params;

import lombok.Data;

/**
 * 统一返回结果
 * @author
 * @DATE 2022/6/21 -14:08
 */
public class BaseRes<T>{
    private Boolean success=true;
    private String code="000";
    private String msg="操作成功";
    private T result;
    private final static String successCode = "000";
    private final static String falseCode = "999";
    private final static String successMsg = "操作成功";
    private final static String falseMsg="操作失败";

    public BaseRes() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
