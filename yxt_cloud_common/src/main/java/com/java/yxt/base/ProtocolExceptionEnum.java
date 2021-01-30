package com.java.yxt.base;

/**
 * 协议层异常信息枚举
 *
 * @author: Ailos
 * @date: 2020/8/29 18:08
 * @version: 1.0
 */
public enum ProtocolExceptionEnum implements IStatusEnum {
	/**
	 * 协议层异常信息
	 */
	INTERNAL_SERVER_ERROR(45000,"服务异常"),
	SEND_MQ_EXCEPTION(45001, "发送MQ消息异常"),
	SEND_DEVICE_EXCEPTION(45002, "发送设备消息异常"),
	DB_OPERATION_EXCEPTION(45003, "数据库操作失败");

	public int code;
	public String message;

	private ProtocolExceptionEnum(int code, String message) {
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
