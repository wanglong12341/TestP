package com.krb.measurement.dto;

/**
 * ajax返回实体
 * @author wyq
 */
public class AjaxResult<T> {
    /**
     * 状态码
     */
    private String code;
    /**
     * 内容
     */
    private String msg;
    /**
     * 数据
     */
    private T data;
    /**
     * 用于存储map数据
     */
    private T mapData;

    public AjaxResult() {
    }

    public AjaxResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public AjaxResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getMapData() {
        return mapData;
    }

    public void setMapData(T mapData) {
        this.mapData = mapData;
    }
}
