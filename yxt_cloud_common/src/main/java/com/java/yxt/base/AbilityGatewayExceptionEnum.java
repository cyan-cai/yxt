/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 能力网关业务异常状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum AbilityGatewayExceptionEnum implements IStatusEnum {
	GATEWAY_ACCESS_EXCEPTION(29999, "回调地址链接超时"), RESOURCE_ACCESS_EXCEPTION(29998, "回调地址链接超时"),
	CALL_BACK_EXCEPTION(29997, "网关回调异常"), FEIGN_PTASVC_CONTINUE_POSITION_EXCEPTION(25102, "位置服务连续定位接口调用异常"),
	FEIGN_PTASVC_SINGLE_POSITION_EXCEPTION(25102, "位置服务定单次位接口调用异常"),
	FEIGN_PTASVC_CANCEL_CONTINUE_POSITION_EXCEPTION(25103, "位置服务取消定位接口调用异常"),
	FEIGN_PTASVC_FENCE_EXCEPTION(25104, "位置服务电子围栏接口调用异常"),
	FEIGN_PTASVC_CANCEL_FENCE_EXCEPTION(25105, "位置服务取消电子围栏接口调用异常"),
	FEIGN_PTASVC_HISTORY_POSTION_EXCEPTION(25106, "查询历史位置调用异常"),
	FEIGN_PTASVC_CANCEL_FENCE_BATCH_EXCEPTION(25107, "位置服务定批量取消电子围栏接口调用异常"),
	FEIGN_PTASVC_CANCEL_CONTINUE_POSITION_BATCH_EXCEPTION(25108, "位置服务批量取消定位接口调用异常"),
	FEIGN_SPMGRSVC_SELECT_TENANTID_EXCEPTION(25109, "综合管理查询租户ID接口调用异常"),
	FEIGN_SDEOPABLITYSV_DOWNLINK_INSTRUCTION_EXCEPTION(25109, "综合管理查询租户ID接口调用异常"),
	FEIGN_MSGCONFIG_SPSEND_EXCEPTION(25109, "行业短信SP主动下发行业短信接口调用异常"),;

	public int code;
	public String message;

	private AbilityGatewayExceptionEnum(int code, String message) {
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
