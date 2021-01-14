package com.banday.app.coupon.vo;

import java.util.HashMap;

public class R extends HashMap<String,Object> {
    public static final String MSG = "msg";
    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String TOTAL = "total";

    public R() {}

    public R(ResultEnum resultEnum) {
        this.put(MSG,resultEnum.getMsg());
        this.put(CODE,resultEnum.getCode());
    }

    /**
     * 正确响应
     */
    public static R ok(){
        return new R(ResultEnum.OK);
    }

    /**
     * 正确响应，返回数据
     */
    public static R ok(Object data){
        R ok = ok();
        ok.put(DATA,data);
        return ok;
    }

    /**
     * 正确响应，返回分页数据
     */
    public static R ok(Object data,Long total){
        R ok = ok(data);
        ok.put(TOTAL,total);
        return ok;
    }

    /**
     * 默认错误
     */
    public static R error(){
        return new R(ResultEnum.ERROR);
    }

    /**
     * 其他错误
     */
    public static R error(ResultEnum resultEnum){
        return new R(resultEnum);
    }

}
