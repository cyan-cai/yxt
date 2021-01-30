package com.java.yxt.base;

/**
 * 
 * @Description 业务校验和异常状态码枚举定义
 * @author lfl
 * @date 2020年8月26日
 */
public interface IStatusEnum {
	/**
	 * 获取状态码
	 * @Title: getCode
	 * @Description: 获取状态码
	 * @param @return 参数 
	 * @return int 返回类型  状态码
	 * @throws
	 */
	public int getCode();
	    
	/**
	 * 获取提示信息
	 * @Title: getMessage
	 * @Description: 获取提示信息
	 * @param @return 参数
	 * @return String 返回类型   提示信息
	 * @throws
	 */
	public String getMessage();
}
