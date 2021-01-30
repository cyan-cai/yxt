package com.java.yxt.util;

import java.util.Collection;
import java.util.Map;

/**
 * 校验工具类
 *
 * @author Ailos
 * @version 1.0
 * @date 2020/8/29 16:37
 */
public class ValidateUtil {
    /**
     * 对象空判断
     * @param value 对象
     * @return 成功标识
     */
    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        }

        if (value instanceof String) {
            return ((String) value).length() == 0;
        }
        if (value instanceof Collection) {
            return ((Collection<? extends Object>) value).isEmpty();
        }
        if (value instanceof Map) {
            return ((Map<? extends Object, ? extends Object>) value).size() == 0;
        }
        if (value instanceof CharSequence) {
            return ((CharSequence) value).length() == 0;
        }

        if (value instanceof Boolean) {
            return false;
        }
        if (value instanceof Number) {
            return false;
        }
        if (value instanceof Character) {
            return false;
        }
        if (value instanceof java.util.Date) {
            return false;
        }
        return false;
    }

    /**
     * 对象非空判断
     * @param value 对象
     * @return 成功标识
     */
    public static boolean isNotEmpty(Object value){
        return !isEmpty(value);
    }
}
