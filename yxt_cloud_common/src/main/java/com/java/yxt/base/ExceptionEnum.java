/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 基础异常状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum ExceptionEnum implements IStatusEnum {
	DB_OPT_EXCEPTION(15001, "数据库操作异常"), FEIGN_TIMEOUT_EXCEPTION(15002, "FEIGN调用超时")
	;

	public int code;
	public String message;

	private ExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
