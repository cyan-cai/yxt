/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 位置跟踪业务异常状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum PositionExceptionEnum implements IStatusEnum {
	/**
	 * 351xx 对接短信网关的异常
	 * 3510x 位置定位命令相关
	 * 3511x 取消定位命令相关
	 * 3512x 电子围栏命令相关
	 * 3513x 其他异常
	 */
	POSITION_IOT_SUCCESS_CODE(30000,"位置请求下发到物联网协议微服务成功"),
	POSITION_TERMINAL_REJECT(30011,"终端拒绝上报请求"),
	POSITION_TERMINAL_CANCEL(30012,"终端取消上报请求"),
	POSITION_SERVICE_EXCEPTION(35000,"位置跟踪精定位服务异常 "),
	POSITION_SERVICE_ERROR(35001,"位置跟踪精定位系统异常"),
	POSITION_POSITIONING_DOWN(35100,"定位下发命令异常"),
	POSITION_CANCEL_DOWN(35110,"取消定位下发命令异常"),
	POSITION_ELECTRICFENCE_DOWN(35120,"电子围栏下发命令异常"),
	POSITION_ELECTRICFENCE_CANCEL_DOWN(35130,"取消电子围栏下发命令异常"),
	POSITION_CONNECT_FAIL(35140,"短信网关连接失败"),
	POSITION_IOT_CONFIRM_FAIL(35150,"位置短数据下行请求确认处理失败"),

	/**
	 * 37xxx 位置Saas与位置服务相关的异常
	 */
	SAAS_TERMINAL_INFO_QUERY_EXCEPTION(37001,"终端信息查询异常"),
	SAAS_OMSRV_PARAM_QUERY_EXCEPTION(37002,"运营管理参数查询异常"),
	SAAS_FEIGN_OPERATION_LINK_EXCEPTION(37003,"运营管理微服务调用，网络通信连接异常"),
	SAAS_FENCE_INFO_ADD_EXCEPTION(37100,"电子围栏信息新增异常"),
	SAAS_FENCE_INFO_NAME_REPEAT_EXCEPTION(37101,"新增电子围栏异常，电子围栏名称重复"),
	SAAS_FENCE_INFO_UPDATE_EXCEPTION(37110,"电子围栏信息更新异常"),
	SAAS_FENCE_INFO_DELETE_EXCEPTION(37120,"删除电子围栏异常"),
	SAAS_FENCE_TERMINAL_QUERY_EXCEPTION(37130,"查询电子围栏终端列表异常"),
	SAAS_FENCE_TERMINAL_DELETE_EXCEPTION(37130,"删除围栏终端异常"),
	SAAS_FENCE_LIST_QUERY_EXCEPTION(37140,"查询电子围栏终端列表异常"),
	SAAS_FENCE_POSITION_INFO_QUERY_EXCEPTION(37141,"电子围栏显示终端位置异常"),
	SAAS_FENCE_SET_TERMINAL_EXCEPTION(37142,"设置电子围栏终端异常"),
	SAAS_FENCE_SEND_EXCEPTION(37150,"电子围栏下发异常"),
	SAAS_FENCE_CANCEL_SEND_PERSISTENCE_EXCEPTION(37151,"取消电子围栏下发命令异常"),
	SAAS_FENCE_CANCEL_SEND_RECEIVE_NUMBNER_EXCEPTION(37152,"取消电子围栏返回流水号异常"),
	SAAS_FENCE_CANCEL_SEND_EXCEPTION(37142,"取消电子围栏异常"),
	SAAS_FENCE_CANCEL_PART_FAIL_EXCEPTION(37143,"取消电子围栏，失败"),
	SAAS_FENCE_CANCEL_AIMLESS_EXCEPTION(37144,"所选终端状态为未下发，取消失败"),
	SAAS_FENCE_HISTORY_QUERY_EXCEPTION(37200,"越界告警历史位置查询异常"),
	SAAS_FENCE_HISTORY_EXPORT_EXCEPTION(37201,"越界告警历史信息导出异常"),
	SAAS_SINGLE_POSITIONING_SEND_EXCEPTION(37300,"单次定位增值业务请求发送异常"),
	SAAS_SINGLE_POSITIONING_PERSISTENCE_EXCEPTION(37301,"单次定位数据持久化异常"),
	SAAS_CONTINUITY_POSITIONING_SEND_EXCEPTION(37310,"连续定位增值业务请求发送异常"),
	SAAS_CONTINUITY_POSITIONING_PERSISTENCE_EXCEPTION(37311,"连续定位数据持久化异常"),
	SAAS_CONTINUTY_POSITIONING_INFO_QUERY_EXCEPTION(37312,"连续定位中，位置信息查询异常"),
	SAAS_CANCEL_CONTINUITY_POSITIONING_SEND_EXCEPTION(37320,"取消连续定位增值业务请求发送异常"),
	SAAS_CANCEL_CONTINUITY_POSITIONING_PERSISTENCE_EXCEPTION(37321,"取消连续定位数据持久化异常"),
	SAAS_CANCEL_CONTINUITY_POSITIONING_PART_FAIL_EXCEPTION(37322,"取消连续定位,失败"),
	SAAS_CANCEL_CONTINUITY_POSITIONING_AIMLESS_EXCEPTION(37323,"批量取消连续定位，失败，未查询到有定位中的终端"),
	SAAS_POSITION_HISTORY_QUERY_EXCEPTION(37400,"位置历史信息查询异常"),
	SAAS_POSITION_HISTORY_EXPORT_EXCEPTION(37401,"位置历史信息导出异常"),
	SAAS_JSON_TRANS_OBJECT_EXCEPTION(37500,"json转登录用户对象异常"),
	SAAS_RECIVE_POSITION_EXCEPTION(37600,"位置上报，接收数据异常"),
	SAAS_RECIVE_OMSRV_QUERY_EXCEPTION(37601,"位置上报，运营管理参数查询异常"),
	SAAS_RECIVE_FENCE_WARNING_EXCEPTION(37610,"接收围栏告警数据异常"),
	SAAS_RECIVE_ROUGH_PARAM_NULL_EXCEPTION(37620,"粗定位上报，上报数据为空异常"),
	SAAS_RECIVE_COORDINATE_TRANSFORMATION_FAIL_EXCEPTION(37700,"百度坐标转换失败"),
	SAAS_QUERY_CUSTOMER_NAME_FAIL_EXCEPTION(37800,"查询客户名称列表异常"),




	POSITION_SMS_FEIGN_EXCEPTION(38000,"位置服务调用短信中心微服务异常"),
	POSITION_IOT_FEIGN_EXCEPTION(38010,"位置服务调用物联网协议微服务异常"),


	;


	public int code;
	public String message;
	
	private PositionExceptionEnum(int code, String message) {
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
