/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 短报文业务异常状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum ShortMessageExceptionEnum implements IStatusEnum {
	/**
	 * 校验数据库是否存在该用户，不允许重复插入一样的用户
	 */
	FEIGN_MSGSVC_PUSH_EXCEPTION(30001, "消息推送微服务调用异常");

	public int code;
	public String message;
	
	private ShortMessageExceptionEnum(int code, String message) {
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
