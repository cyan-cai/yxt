package com.java.yxt.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.yxt.util.JsonUtil;

/**
 * 0 在所有业务上都表示请求或业务成功 其它不同业务上的code范围定义如下
 * <p>
 * 基础通用 返回代码范围 10000 ~ 19999 校验代码范围 10000 ~ 15000 异常代码范围 15000 ~ 19999
 * <p>
 * 能力网关 返回代码范围 20000 ~ 29999 校验代码范围 20000 ~ 25000 异常代码范围 25000 ~ 29999
 * <p>
 * 位置跟踪 返回代码范围 30000 ~ 39999 校验代码范围 30000 ~ 35000 异常代码范围 35000 ~ 39999
 * <p>
 * 物联网 返回代码范围 40000 ~ 49999 校验代码范围 40000 ~ 45000 异常代码范围 45000 ~ 49999
 * <p>
 * 短报文 返回代码范围 50000 ~ 59999 校验代码范围 50000 ~ 55000 异常代码范围 55000 ~ 59999
 * <p>
 * 行短 返回代码范围 60000 ~ 69999 校验代码范围 60000 ~ 65000 异常代码范围 65000 ~ 69999
 * <p>
 * 具体南向接口网关层返回的状态码 原则上我们不做转换处理，后面具体分析
 *
 * @author lfl
 * @Description TODO
 * @date 2020年8月25日
 */
public class Response<T> {
    private static final Logger logger = LogManager.getLogger(Response.class);

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "成功";

    private int code;

    private String message;

    private T result;

    public Response() {
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, String message, T result) {
        this(code, message);
        this.result = result;
    }

    public Response(IStatusEnum statusEnum) {
        this(statusEnum.getCode(), statusEnum.getMessage());
    }

    public static Response<?> success() {
        return new Response<>(Response.SUCCESS_CODE, Response.SUCCESS_MESSAGE);
    }

    public static Response<?> OptError() {
        return new Response<>(-1, "失败");
    }

    public static Response<?> dbOptError() {
        return new Response<>(ExceptionEnum.DB_OPT_EXCEPTION);
    }

    public static <T> Response<T> successWithResult(T result) {
        return new Response<>(Response.SUCCESS_CODE, Response.SUCCESS_MESSAGE, result);
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        try {
            return JsonUtil.objectToString(this, getClass().getName());
        } catch (JsonProcessingException e) {
            logger.error("{} 转json异常", getClass().getName(), e);
        }
        return "";
    }

}