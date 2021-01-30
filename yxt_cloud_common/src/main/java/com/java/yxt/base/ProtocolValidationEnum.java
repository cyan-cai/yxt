package com.java.yxt.base;

/**
 * 协议层校验信息枚举
 *
 * @author: Ailos
 * @date: 2020/8/29 18:08
 * @version: 1.0
 */
public enum ProtocolValidationEnum implements IStatusEnum {
	/**
	 * 协议层参数校验
	 */
	PARAM_VALID_FAIL(40000, "参数校验失败"),
	NO_DEVICE_ONLINE(40001, "没有设备在线");

	public int code;
	public String message;

	private ProtocolValidationEnum(int code, String message) {
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
