/**
 * 
 */
package com.java.yxt.util;

import java.util.List;

/**
 * @Description TODO
 * @author lfl
 * @date 2020年8月27日
 */
public class ListUtil {

	/**
	 * @param <T>
	 * 
	 * @Title: isNotBlank
	 * @Description: 判断list集合是否不为空
	 * @param @param list
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public static <T> boolean isNotBlank(final List<T> list) {
        return !isBlank(list);
    }
	
	/**
	 * @param <T>
	 * 
	 * @Title: isBlank
	 * @Description: 判断list集合是否为空
	 * @param @param list
	 * @param @return 参数 
	 * @return boolean 返回类型
	 * @throws
	 */
	public static <T> boolean isBlank(final List<T> list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		
		return false;
	}
	
}
