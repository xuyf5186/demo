package com.stringboot.demo.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/19
 * Time 19:30
 */
public class SignUtil {
    /**
     * Object转Map
     * @param bean 要转的实例
     * @return TreeMap
     */
    public static TreeMap<String,String> object2Map(Object bean)
    {
        TreeMap<String, String> requestMap = new TreeMap<String, String>();
        Class<?> cls = bean.getClass();
        //获取属性集合
        Field[] fields = cls.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                String key = fields[i].getName();//获取属性名
                fields[i].setAccessible(true);//private修饰的属性必须加上这一句
                Object value = fields[i].get(bean);//获取属性值
                if ("sign".equals(key) || value == null || StringUtils.isEmpty(value.toString())) {
                    continue;
                }
                requestMap.put(key, value.toString());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return requestMap;
    }
    /**
     * 将map连接成字符串
     * @param map
     *                  map
     * @param prefix
     *                  前缀
     * @param suffix
     *                  后缀
     * @param separator
     *                  连接符
     * @param ignoreEmptyValue
     *                  忽略空值
     * @param ignoreKeys
     *                  忽略key
     * @return   String
     */
    public static String MapToString(Map<String, Object> map, String prefix, String suffix, String separator,
                                      boolean ignoreEmptyValue, String... ignoreKeys) {
        List<String> list = new ArrayList<String>();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = String.valueOf(entry.getValue());
                if (StringUtils.isNotEmpty(key) && !ArrayUtils.contains(ignoreKeys, key)
                        && (!ignoreEmptyValue || StringUtils.isNotEmpty(value))) {
                    list.add(key + "=" + (value != null ? value : ""));
                }
            }
        }
        //加上前缀后缀，中间插入连接符
        return (prefix != null ? prefix : "") + StringUtils.join(list, separator) + (suffix != null ? suffix : "");
    }
}
