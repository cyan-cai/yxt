/**
 * 
 */
package com.java.yxt.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @Description TODO
 * @author lfl
 * @date 2020年8月31日
 */
public class MapUtil {

	public static Map<Integer, Set<String>> createSetMap() {
		Map<Integer, Set<String>> map = new HashMap<>();
		if (map != null) {

		}

		return null;
	}

	public static Map<Integer, Set<String>> putSetMap(Map<Integer, Set<String>> map, Integer key, String value) {
//		Map<Integer, Set<String>> map = new HashMap<>();
		Set<String> set = map.get(key);
		if (set != null) {
			set.add(value);
		} else {
			Set<String> innerSet = new HashSet<>();
			innerSet.add(value);
			map.put(key, innerSet);
		}

		return map;
	}

	/**
	 * 
	 * @Title: sortDescByKey @Description: map结构根据key降序 @param @param
	 * <K> @param @param <V> @param @param map @param @return 参数 @return Map<K,V>
	 * 返回类型 @throws
	 */
	public static <K extends Comparable<? super K>, V> Map<K, V> sortDescByKey(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}

	/**
	 * 
	 * @Title: sortDescByValue @Description: map结构根据value降序 @param @param
	 * <K> @param @param <V> @param @param map @param @return 参数 @return Map<K,V>
	 * 返回类型 @throws
	 */
	public <K, V extends Comparable<? super V>> Map<K, V> sortDescByValue(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}

	/**
	 * 
	 * @Title: getHead
	 * @Description: 获取LinkedHashMap中第一个元素 时间复杂度O(1)
	 * @param @param <K>
	 * @param @param <V>
	 * @param @param map
	 * @param @return 参数
	 * @return Entry<K,V> 返回类型
	 * @throws
	 */
	public static <K, V> Entry<K, V> getHead(LinkedHashMap<K, V> map) {
		return map.entrySet().iterator().next();
	}

	/**
	 * 
	 * @Title: getTailByReflection
	 * @Description: 获取LinkedHashMap中第一个元素 时间复杂度O(1)
	 * @param @param <K>
	 * @param @param <V>
	 * @param @param map
	 * @param @return
	 * @param @throws NoSuchFieldException
	 * @param @throws IllegalAccessException 参数
	 * @return Entry<K,V> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Entry<K, V> getTailByReflection(LinkedHashMap<K, V> map)
			throws NoSuchFieldException, IllegalAccessException {
		Field tail = map.getClass().getDeclaredField("tail");
		tail.setAccessible(true);
		return (Entry<K, V>) tail.get(map);
	}
	
	/**
	 * 
	 * @Title: getTail
	 * @Description: 获取LinkedHashMap中第一个元素 时间复杂度O(n)
	 * @param @param <K>
	 * @param @param <V>
	 * @param @param map
	 * @param @return 参数
	 * @return Entry<K,V> 返回类型
	 * @throws
	 */
	public static <K, V> Entry<K, V> getTail(LinkedHashMap<K, V> map) {
	    Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
	    Entry<K, V> tail = null;
	    while (iterator.hasNext()) {
	        tail = iterator.next();
	    }
	    return tail;
	}
	
	/**
	 * 
	 * @Title: isNotBlank
	 * @Description: 判断map集合是否不为空
	 * @param @param <K>
	 * @param @param <V>
	 * @param @param map
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public static <K, V> boolean isNotBlank(final Map<K, V> map) {
        return !isBlank(map);
    }
	
	/**
	 * 
	 * @Title: isBlank
	 * @Description: 判断map集合是否为空
	 * @param @param <K>
	 * @param @param <V>
	 * @param @param map
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public static <K, V> boolean isBlank(final Map<K, V> map) {
		if (map == null || map.size() == 0) {
			return true;
		}
		
		return false;
	}

}
