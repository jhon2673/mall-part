package com.pzh.mall.common;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/23 13:34
 * @Version 1.0
 */
public class ResultMsg<T> {
    private final Integer DEFAULT_CODE = 0;
    private final String DEFAULT_MSG = "请求成功";

    private Integer code;

    private String msg;

    private T data;

    private Long count;

    public ResultMsg() {
        this.code = DEFAULT_CODE;
        this.msg = DEFAULT_MSG;
    }

    public ResultMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultMsg(T data) {
        this();
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
