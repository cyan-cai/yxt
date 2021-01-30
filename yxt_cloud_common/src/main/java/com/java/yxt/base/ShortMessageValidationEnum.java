/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 短报文业务校验状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum ShortMessageValidationEnum implements IStatusEnum {
	/**
	 * 校验数据库是否存在该用户，不允许重复插入一样的用户
	 */
	CUSTOMER_BEAM_CONFIG_EXIST(30001, "客户信道信息已经存在"), WHILTE_VALIDATE_FAILE(20002, "终端设备不在业务白名单中");

	public int code;
	public String message;
	
	private ShortMessageValidationEnum(int code, String message) {
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
