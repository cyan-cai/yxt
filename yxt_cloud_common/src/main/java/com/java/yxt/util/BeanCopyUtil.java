package com.java.yxt.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象复制工具类
 *
 * @Author: Ailos
 * @Date: 2020/4/22 17:14
 * @Version: 1.0
 */
public class BeanCopyUtil {
    /**
     * 对象属性复制
     *
     * @param sourceObj   资源对象
     * @param targetClass 目标Class对象
     * @param <T>         目标对象类型
     * @return 目标对象
     */
    public static <T> T beanCopy(Object sourceObj, Class targetClass) {
        if (sourceObj == null) {
            return null;
        }
        BeanCopier beanCopier = BeanCopier.create(sourceObj.getClass(), targetClass, false);
        T targetObj = null;
        try {
            targetObj = (T) targetClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        beanCopier.copy(sourceObj, targetObj, null);
        return targetObj;
    }

    /**
     * 对象集合属性复制
     *
     * @param sourceList  资源对象集合
     * @param sourceClass 资源Class字节码对象
     * @param targetClass 目标Class字节码对象
     * @param <T>         目标对象类型
     * @return List<T> 目标对象集合
     */
    public static <T> List<T> listCopy(List sourceList, Class sourceClass, Class targetClass) {
        if (sourceList == null) {
            return null;
        }
        BeanCopier beanCopier = BeanCopier.create(sourceClass, targetClass, false);
        List<T> results = new ArrayList<>();
        sourceList.forEach(item -> {
            T targetObj = null;
            try {
                targetObj = (T) targetClass.newInstance();

            } catch (Exception e) {
                e.printStackTrace();
            }
            beanCopier.copy(item, targetObj, null);
            results.add(targetObj);
        });
        return results;
    }
}
