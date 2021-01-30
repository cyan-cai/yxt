package com.java.yxt.constant;

/**
 * 公共常量类
 *
 * @author Ailos
 * @version 1.0
 * @date 2020/8/29 15:00
 */
public final class CommonConst {
	/** 特殊字符：英文逗号 */
	public static final String SPECIAL_CHARACTERS_COMMA = ",";

	/** 特殊字符：英文句号 */
	public static final String SPECIAL_CHARACTERS_SPOT = ".";

	/** 特殊字符：英文冒号 */
	public static final String SPECIAL_CHARACTERS_COLON = ":";

	/** 特殊字符：空格 */
	public static final String SPECIAL_CHARACTERS_SPACE = " ";

	/** 特殊字符：中横线 */
	public static final String SPECIAL_CHARACTERS_HYPHEN = "-";

	/** 特殊字符：下划线 */
	public static final String SPECIAL_CHARACTERS_UNDERLINE = "_";

	/** 特殊字符：星号 */
	public static final String SPECIAL_CHARACTERS_STAR = "*";

	/** 特殊字符：空字符串 */
	public static final String SPECIAL_CHARACTERS_EMPTY = "";

    /** 特殊字符：括号【 */
    public static final String SPECIAL_CHARACTERS_BRACKET_START = "【";

    /** 特殊字符：括号】 */
    public static final String SPECIAL_CHARACTERS_BRACKET_END = "】";

	/** 无符号byte类型最大值 */
	public static final int MAX_BYTE_VALUE = 255;

	/** 最小正整数 */
	public static final int SMALLEST_POSITIVE_VALUE = 1;

	/** 单次定位ci使用范围 */
	public static final Integer[] SINGLE_CI_ARR = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
			20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
			47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73,
			74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
			101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120 };

	/** 连续定位ci使用范围 */
	public static final Integer[] CONTINUE_CI_ARR = { 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133,
			134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154,
			155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175,
			176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196,
			197, 198, 199, 200 };

	/** 电子围栏ci使用范围 */
	public static final Integer[] FENCE_CI_ARR = { 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214,
			215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235,
			236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255 };

	/** 单次定位类型 */
	public static final short SINGLE_MESSAGE_TYPE = 1;
	/** 连续定位类型 */
	public static final short CONTINUE_MESSAGE_TYPE = 2;
	/** 平台取消连续定位类型 */
	public static final short CANCEL_CONTINUE_MESSAGE_TYPE = 3;
	/** 电子围栏类型 */
	public static final short FENCE_MESSAGE_TYPE = 4;
	/** 取消设置电子围栏类型 */
	public static final short CANCEL_FENCE_MESSAGE_TYPE = 5;
	/** 终端上报位置报告类型 */
	public static final short REPORT_MESSAGE_TYPE = 10;
	/** 终端拒绝上报请求 */
	public static final short TERMINAL_REJECT_MESSAGE_TYPE = 11;
	/** 终端取消上报请求 */
	public static final short TERMINAL_CANCEL_MESSAGE_TYPE = 12;
	
	/** 终端开关机上报 */
	public static final short SWITCH_MESSAGE_REPORT_TYPE = 0;
	/** 单次定位上报 */
	public static final short SINGLE_MESSAGE_REPORT_TYPE = 1;
	/** 连续定位上报 */
	public static final short CONTINUE_MESSAGE_REPORT_TYPE = 2;
	/** 终端主动上报 */
	public static final short ACTIVE_MESSAGE_REPORT_TYPE = 3;
	/** 电子围栏终端上报告警 */
	public static final short FENCE_MESSAGE_REPORT_TYPE = 4;

	/** 短信 */
	public static final short SMS_CHANNEL = 1;

	/** 短数据 */
	public static final short IOT_CHANNEL = 2;

	/** 粗定位 */
	public static final short ROUGH_CHANNEL = 3;

	/** 所有 */
	public static final String ALL = "all";

	/** 单次定位ci过期时间 单位分钟 */
	public static final int SINGLE_CI_EXPIRE_TIME = 60;

	/** 没有释放的ci是否允许再次使用 true 允许 false 不允许 */
	public static final boolean NOT_ALLOW_CI_REUSE = false;

	/** 没有释放的ci是否允许再次使用 true 允许 false 不允许 */
	public static final boolean ALLOW_CI_REUSE = true;

	/** 一次定位请求最大允许终端数量 */
	public static final int MAX_MSISDN_NUM = 100;

	/** 参考 《L1接口技术要求( 基本要求)_（客户提供的原始版本）.do》中的 POSITIONRESULT */
	public static final int NOT_REPORTED_POSITION_RESULT = 23;

	/** 基于短数据位置定位 给短数据适配微服务的 serverid */
	public static final short SERVER_ID = 10001;

	/** 连续定位两次相邻定位间的时间间隔 最小值 90 单位秒 */
	public static final int MIN_TIME_INTERVAL = 5;

	/** 连续定位两次相邻定位间的时间间隔 最大值 单位秒 */
	public static final int MAX_TIME_INTERVAL = 65535;

	public static final String MAIN_SEQUENCE_PREFIX = "primary_";

	/** 分布式锁获取ci最大的锁定时间 单位秒 */
	public static final int MAX_TIME_CI_LOCK = 30;

	/** 分布式锁获取最大的长消息参考号锁定时间 单位秒 */
	public static final int MAX_TIME_LMR_LOCK = 5;

	/** 租户id 暂时写默认值 1 */
	public static final Long TENANT_ID = 1L;

}
