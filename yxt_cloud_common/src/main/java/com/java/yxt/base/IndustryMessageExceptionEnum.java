/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 行短业务异常状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum IndustryMessageExceptionEnum implements IStatusEnum {
	/**
	 * 行短业务异常
	 */
	INDUSTRY_TEXTMSG_DOWN(65100,"普通文字短信下发命令异常"),
	INDUSTRY_CONNECT_FAIL(65110,"短信网关连接失败"),
	COMPLIANCE_FEIGN_EXCEPTION(66100,"敏感词校验feign调用失败，熔断方法调用"),
	OPERATION_MANAGE_MT_FEIGN_EXCEPTION(66101,"黑名单主被叫feign调用失败(MT)，熔断方法调用"),
	INDUSTRY_MESSAGE_MT_SEND_FEIGN_EXCEPTION(66102,"发送行业短信_feign调用失败(MT)，熔断方法调用"),
	OPERATION_MANAGE_MO_BLACK_LIST_FEIGN_EXCEPTION(66103,"黑名单主被叫feign调用失败(MO)，熔断方法调用"),
	OPERATION_MANAGE_MO_CUSTOMER_CALLBACKURL_EXCEPTION(66104,"获取客户回调地址_feign调用失败(MO)，熔断方法调用");

	public int code;
	public String message;
	
	private IndustryMessageExceptionEnum(int code, String message) {
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
