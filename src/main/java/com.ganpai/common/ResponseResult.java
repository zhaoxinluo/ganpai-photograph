package com.ganpai.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by luyunfei on 17/04/2017.
 * 请求响应封装类
 * 1. 用于模块间调用接口时，接口的响应
 * 2. 用于Http请求时，反馈结果给前端
 */
public class ResponseResult<T> implements Serializable {

    /**
     * 常用的返回码枚举
     */
    public enum ResponseCode {
        SUCCESS(200, "success"),
        MOBILE(201, "mobile"),//找回密码  按照手机号码找回表示
        EMAIL(202, "email"),//找回密码, 按照邮箱找回
        FAILED(500, "failed"),
        TO_LOGIN_FAILED(401, "to login"),
        TO_HOME_PAGE_FAILED(402, "to home page"),
        FAILED_PARAM_ERROR(501, "params is invalid");

        private int code;
        private String message;

        ResponseCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    private T data;

    private Date now;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.now = new Date();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public boolean iSuccess() {
        return ResponseCode.SUCCESS.getCode() == this.getCode();
    }

    public boolean iFailed() {
        return ResponseCode.SUCCESS.getCode() != this.getCode();
    }

    /**
     * 创建没有返回值时的返回对象
     *
     * @return
     */
    public static ResponseResult success() {

        ResponseResult result = new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());

        return result;
    }

    /**
     * 创建有返回值时的返回对象
     *
     * @param data
     * @return
     */
    public static ResponseResult success(Object data) {

        ResponseResult result = new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        result.setData(data);

        return result;
    }

    /**
     * 创建有返回值时的返回对象
     *
     * @param data
     * @return
     */
    public static ResponseResult success(int code,String message,Object data) {

        ResponseResult result = new ResponseResult(code, message);
        result.setData(data);

        return result;
    }


    /**
     * 创建调用失败时的返回对象, 使用默认的失败描述
     *
     * @return
     */
    public static ResponseResult failed() {
        ResponseResult result = new ResponseResult(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage());
        return result;
    }

    /**
     * 调用失败的返回对象, 使用自定义的失败描述
     *
     * @param message
     * @return
     */
    public static ResponseResult failed(String message) {
        ResponseResult result = new ResponseResult(ResponseCode.FAILED.getCode(), message);
        return result;
    }

    /**
     * 调用失败的返回对象, 使用自定义的失败码,失败描述
     *
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult failed(int code,String message) {
        ResponseResult result = new ResponseResult(code, message);
        return result;
    }

    /**
     * 创建返回对象, 自定义返回码和返回值
     *
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult instance(int code, String message) {
        ResponseResult result = new ResponseResult(code, message);
        return result;
    }
}
