package com.banday.app.coupon.vo;

/**
 * @Author: banday
 */
public enum ResultEnum {
    /**
     * 成功
     */
    OK(2000,"请求成功"),
    /**
     * 失败
     */
    ERROR(5000,"请求错误"),
    /**
     * 参数错误
     */
    UNVALID(4000,"请求参数错误"),
    ;
    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultEnum() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
