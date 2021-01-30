/**
 * 
 */
package com.java.yxt.constant;

/**
 * 固定的redis缓存以_KEY结尾，以微服务名作为前缀 redis缓存key不是固定以_DIR结尾，以微服务名作为前缀
 * redis缓存分布式锁key如果是固定的_LOCK结尾，以微服务名作为前缀
 * redis缓存分布式锁key如果是前缀部分的_PREFIX_LOCK结尾，以微服务名作为前缀
 * 
 * @Description TODO
 * @author lfl
 * @date 2020年11月5日
 */
public final class RedisKeyConst {

	/**
	 * 位置物联网电子围栏下发流水号记录 RMap<String, List<String>> msisdn,List<String>
	 */
	public static final String POSITION_FENCE_IOT_SEQUENCE_KEY = "position:fence:iot:sequence";
	
	public static final String POSITION_SINGLE_MSISDN_DIR = "position:single:msisdn:";
	
	
	/**
	 * 终端和服务类型查对应的回调地址对应的map名称 key：为msisdn+服务类型*value:回调地址url
	 */
	public static final String OM_MSISDNCALLBACKURL_KEY = "terminal:msisdn:callbackurl";
	/**
	 * --------------------------------------------------------------------------能力网关start----------------------------------------------------------------------------------------
	 * redis路由信息key
	 */
	public static final String GATEWAY_ROUTE_INFO_KEY = "gateway:routes:info";
	/**
	 * redis api限流配置key
	 */
	public static final String GATEWAY_ROUTE_LIMIT_KEY = "gateway:rate:limit:route";

	/**
	 * redis 业务标识限流限流配置key
	 */
	public static final String GATEWAY_SERVICE_LIMIT_KEY = "gateway:rate:limit:service";

	/**
	 * redis api每秒限流key
	 */
	public static final String GATEWAY_ROUTE_SECOND_RATE_LIMIT_DIR = "gateway:rate:routes:second:";
	/**
	 * redis api每日限流key
	 */
	public static final String GATEWAY_ROUTE_DAY_RATE_LIMIT_DIR = "gateway:rate:routes:day:";
	/**
	 * redis api每月限流key
	 */
	public static final String GATEWAY_ROUTE_MONTH_RATE_LIMIT_DIR = "gateway:rate:routes:month:";

	/**
	 * redis业务标识每秒限流key
	 */
	public static final String GATEWAY_SERVICE_SECOND_RATE_LIMIT_DIR = "gateway:rate:services:second:";
	/**
	 * redis业务标识每日限流key
	 */
	public static final String GATEWAY_SERVICE_DAY_RATE_LIMIT_DIR = "gateway:rate:services:day:";
	/**
	 * redis业务标识每月限流key
	 */
	public static final String GATEWAY_SERVICE_MONTH_RATE_LIMIT_DIR = "gateway:rate:services:month:";

	/**
	 * redis路由规则目录
	 */
	public static final String GATEWAY_API_RATE_DIR = "gateway:apiRateRules:";
	/**
	 * redis业务标识白名单目录
	 */
	public static final String GATEWAY_SERVICE_WHILTE_DIR = "gateway:whilteList:";
	/**
	 * redis业务标识白名单目录
	 */
	public static final String GATEWAY_CUSTOMER_INFO_DIR = "gateway:customer:";

	/**
	 * redis customerCode 和 租户id对应关系
	 */
	public static final String GATEWAY_CUSTOMER_CODE_TENANT_ID_DIR = "gateway:customer:code:";

	/**
	 * --------------------------------------------------------------------------能力网关end----------------------------------------------------------------------------------------
	 */
	
	
	
	
}
