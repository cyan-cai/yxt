/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 能力网关业务校验状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum AbilityGatewayValidationEnum implements IStatusEnum {
	ROUTE_NOT_EXIST(20001, "路由信息不存在"), WHILTE_VALIDATE_FAILE(20002, "终端设备不在业务白名单中"),
	SERVICE_CODE_IS_BLANK(20003, "业务标识为空"), TERMINALID_IS_BLANK(20004, "终端号为空"),
	SERVICE_INFO_IS_BLANK(20005, "请携带业务标识信息"), OVER_ROUTE_SECOND_LIMIT(20006, "请求过于频繁，超过API每秒限流"),
	OVER_ROUTE_DAY_LIMIT(20007, "请求过于频繁，超过API每日限流"), OVER_ROUTE_MONTH_LIMIT(20008, "请求过于频繁，超过API每月限流"),
	OVER_ROUTE_DATE_PREIOD(20009, "请求不在API允许的时间范围内"), OVER_SERVICE_DATE_PREIOD(20011, "请求不在业务允许的时间范围内"),
	PARAM_FORMAT_EXCEPPTION(20010, "参数格式化异常"), OVER_SERVICE_SECOND_LIMIT(20012, "请求过于频繁，超过该业务每秒限流"),
	OVER_SERVICE_DAY_LIMIT(20013, "请求过于频繁，超过该业务每日限流"), OVER_SERVICE_MONTH_LIMIT(20014, "请求过于频繁，超过该业务每月限流"),
	CALLBACK_URL_IS_BLANK(20015, "回调地址为空"), CUSTOMER_CODE_IS_BLANK(20016, "客户信息不存在"),
	CUSTOMER_STATUS_ERROR(20017, "客户信息为空"), CUSTOMER_ORDER_ERROR(20018, "客户信息为空"),
	POSITION_TYPE_IS_NULL(20019, "聚合定位类型为空"), CANCEL_TYPE_IS_NULL(20020, "聚合取消类型为空"),
	SERVICE_CODE_IS_FAILURE(20021, "业务标识不在时效范围内");

	public int code;
	public String message;

	private AbilityGatewayValidationEnum(int code, String message) {
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
