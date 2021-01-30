package com.java.yxt.base;

/**
 * @author lfl
 * @Description 业务校验和异常状态码枚举定义
 * @date 2020年8月26日
 */
public enum PositionInfoEnum implements IStatusEnum {

	POSITION_SWITCH_REPORT(0, "开关机上报"),
	POSITION_SINGLE_REPORT(1, "单次定位上报"),
    POSITION_CONTINUATION_REPORT(2, "连续定位上报"),
    POSITION_PROACTIVE_REPORT(3, "终端主动上报"),
    POSITION_REJECT_REPORT(11, "终端拒绝上报请求"),
    POSITION_CANCEL_REPORT(12, "终端取消上报请求"),
    POSITION_ALARM_REPORT(4, "电子围栏终端上报告警");

    public int code;
    public String message;

    private PositionInfoEnum(int code, String message) {
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
