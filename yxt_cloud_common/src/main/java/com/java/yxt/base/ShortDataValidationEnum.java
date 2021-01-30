/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 短数据业务校验状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum ShortDataValidationEnum implements IStatusEnum {
	;

	public int code;
	public String message;
	
	private ShortDataValidationEnum(int code, String message) {
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
