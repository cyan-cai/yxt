/**
 * 
 */
package com.java.yxt.base;

/**
 * @Description 位置跟踪业务校验状态码定义
 * @author lfl
 * @date 2020年8月26日
 */
public enum PositionValidationEnum implements IStatusEnum {
	/**
	 * 定位属性值校验
	 */
	NOTIFICATION_AND_VERIFICATION_INDICATOR(30001, "指示终端是否需要通知终端用户和等待确认，值为0、1或2，参数不正确，请检查"),
	POSITIONING_TECHNOLOGY_INDICATOR(30002, "定位技术。北斗定位‘00000000’，其他值保留，且不能大于255，参数不正确，请检查"),
	POSITIONING_QOS_INCLUDED(30003, "定位QoS指示，值为0或1，参数不正确，请检查"),
	POSITIONING_QOS(30004, "定位QoS等级，本域定义从0到255的QoS等级，参数不正确，请检查"),
	POSITIONING_MODE(30005, "本域保留。默认为‘00000000’，且不能大于255，参数不正确，请检查"),
	POSITIONING_NUMBER_TOOMANY(30006,"短信接收方号码数量超限，不允许超过100个"),
	POSITIONING_MSISDN_NUMBER(30010, "定位终端号码数量范围在1~100之间，参数不正确，请检查"),

	POSITIONING_CI_PART_LACK(30030, "下发请求终端号码的Correlation Identifier部分不足，请检查正在定位的终端号码"),
	POSITIONING_CI_ALL_LACK(30031, "下发请求终端号码的Correlation Identifier全部不足，请检查正在定位的终端号码"),
	POSITIONING_CHANNEL_INVALID(30036, "下发请求定位渠道不正确 1:短信；2:短数据，参数不正确，请检查"),

	BASIC_DATE_TIME_INVALID(30040, "日期时间格式不符合yyyyMMddHHmmss这种格式，请检查"),
	POSITIONING_TIME_INTERVAL_INVALID(30041, "终端两次相邻定位间的时间间隔，其单位为秒，有效取值范围为90到65535秒，参数不正确,请检查"),
	START_END_TIME_INVALID(30042, "开始时间不能小于结束时间，参数不正确,请检查"),

	FENCE_LONGITUDE_TYPE_INVALID(30050, "电子围栏经度类型格式应为[1,0,1,0]，0:东经；1:西经，参数不正确，请检查"),
	FENCE_LATITUDE_TYPE_INVALID(30051, "电子围栏纬度类型格式应为[1,0,1,0]，0:南纬；1:北纬，参数不正确，请检查"),
	FENCE_LONGITUDE_DATA_INVALID(30052, "电子围栏经度数据格式应为[0.0,0.0,0.0,0.0]，参数不正确，请检查"),
	FENCE_LATITUDE_DATA_INVALID(30053, "电子围栏经度数据格式应为[0.0,0.0,0.0,0.0]，参数不正确，请检查"),

	/**
	 * 33xxx 位置Saas校验码
	 */
	SAAS_MSISDN_VERIFICATION_FAIL(33001,"终端号码必填校验失败，请检查！"),
	SAAS_MSISDN_SIZE_VERIFICATION_FAIL(33002,"终端号码长度校验失败，请检查！"),
	SAAS_PAGENUM_VERIFICATION_FAIL(33003,"分页查询当前页数必填校验失败，请检查！"),
	SAAS_PAGESIZE_VERIFICATION_FAIL(33004,"分页查询每页显示条数必填校验失败，请检查！"),
	SAAS_SAME_PARAM_VERIFICATION_FAIL(33005,"不能同时下发不同业务类型的终端定位命令，请检查！"),
	SAAS_SAME_CHANNEL_VERIFICATION_FAIL(33006,"不能同时下发不同渠道的终端定位命令，请检查！"),
	SAAS_PARAM_CHANNEL_VERIFICATION_FAIL(33007,"Channel字段校验失败，不能为空或者空串，请检查！"),
	SAAS_PARAM_SIZE_VERIFICATION_FAIL(33007,"粗定位推送校验失败，推送数据数量必须大于零！"),
	SAAS_FENCE_DELETE_FAIL(33100,"无法删除选中的电子围栏，因为有下发正在生效的终端，请先取消电子围栏！")
	;
	public int code;
	public String message;
	
	private PositionValidationEnum(int code, String message) {
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
