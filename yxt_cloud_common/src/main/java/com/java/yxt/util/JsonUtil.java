package com.java.yxt.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version:
 * @Description:
 * @author: lifeilong
 * @date: 2020年2月18日 上午11:05:34
 */
public class JsonUtil {
	
	/**
     * 
       
     * object2json(object转json)       
     * @param  @param obj
     * @param  @return    
     * @return String 
     * @Exception 异常对象
     */
    public static String object2json(Object obj)
    {
        StringBuilder json = new StringBuilder();
        if (obj == null)
        {
            json.append("\"\"");
        }
        else if (obj instanceof String || obj instanceof Integer || obj instanceof Float
                || obj instanceof Boolean || obj instanceof Short || obj instanceof Double
                || obj instanceof Long || obj instanceof BigDecimal || obj instanceof BigInteger
                || obj instanceof Byte)
        {
            json.append("\"").append(string2json(obj.toString())).append("\"");
        }
        else if (obj instanceof Object[])
        {
            json.append(array2json((Object[]) obj));
        }
        else if (obj instanceof List)
        {
            json.append(list2json((List<?>) obj));
        }
        else if (obj instanceof Map)
        {
            json.append(map2json((Map<?, ?>) obj));
        }
        else if (obj instanceof Set)
        {
            json.append(set2json((Set<?>) obj));
        }
        else
        {
            json.append(bean2json(obj));
        }
        return json.toString();
    }
	
    /**
     * 
       
     * bean2json(实体bean转json)       
     * @param  @param obj
     * @param  @return    
     * @return String 
     * @Exception 异常对象
     */
    public static String bean2json(Object bean)
    {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try
        {
            props = Introspector.getBeanInfo(bean.getClass(), Object.class)
                    .getPropertyDescriptors();
        }
        catch (IntrospectionException e)
        {
        }
        if (props != null)
        {
            for (int i = 0; i < props.length; i++)
            {
                try
                {
                    String name = object2json(props[i].getName());
                    String value = object2json(props[i].getReadMethod().invoke(bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                }
                catch (Exception e)
                {
                }
            }
            json.setCharAt(json.length() - 1, '}');
        }
        else
        {
            json.append("}");
        }
        return json.toString();
    }

    
    /**
     * 
       
     * list2json(集合转json)       
     * @param  @param list
     * @param  @return    
     * @return String 
     * @Exception 异常对象
     */
    public static String list2json(List<?> list)
    {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0)
        {
            for (Object obj : list)
            {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        }
        else
        {
            json.append("]");
        }
        return json.toString();
    }

    
    /**
     * 
       
     * array2json(数组转json)       
     * @param  @param array
     * @param  @return    
     * @return String 
     * @Exception 异常对象
     */
    public static String array2json(Object[] array)
    {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0)
        {
            for (Object obj : array)
            {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        }
        else
        {
            json.append("]");
        }
        return json.toString();
    }

    
    /**
     * 
       
     * map2json(这里用一句话描述这个方法的作用)       
     * @param  @param map
     * @param  @return    
     * @return String 
     * @Exception 异常对象
     */
    public static String map2json(Map<?, ?> map)
    {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0)
        {
            for (Object key : map.keySet())
            {
                json.append(object2json(key));
                json.append(":");
                json.append(object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        }
        else
        {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * 
       
     * set2json(set集合转json)       
     * @param  @param set
     * @param  @return    
     * @return String 
     * @Exception 异常对象
     */
   
    public static String set2json(Set<?> set)
    {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0)
        {
            for (Object obj : set)
            {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        }
        else
        {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * string2json(String转Json)
     *
     * @param @param  s
     * @param @return
     * @return String
     * @Exception 异常对象
     */
    public static String string2json(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F') {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    } else {
                        sb.append(ch);
                    }
            }
        }
        return sb.toString();
    }

    /**
     * json2Object(Json转对象)
     *
     * @param @param  jsonString
     * @param @param  type
     * @param @return
     * @return T
     * @Exception 异常对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2Object(String jsonString, Class<T> type) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (T) mapper.readValue(jsonString, type);
    }

    /**
     *
     *
     * json2List(Json转List集合)
     *
     * @param @param  jsonArr
     * @param @return
     * @return List<Object>
     * @Exception 异常对象
     */
//	public static List<Object> json2List(JSONArray jsonArr) {
//		List<Object> list = new ArrayList<Object>();
//		for (Object obj : jsonArr) {
//			if (obj instanceof JSONArray) {
//				list.add(json2List((JSONArray) obj));
//			} else if (obj instanceof JSONObject) {
//				list.add(json2Map((JSONObject) obj));
//			} else {
//				list.add(obj);
//			}
//		}
//		return list;
//	}

    /**
     * json2Map(Json字符串转Map)
     *
     * @param @param  json
     * @param @return
     * @return Map<String,Object>
     * @Exception 异常对象
     */
//	public static Map<String, Object> json2Map(String json) {
//		JSONObject obj = (JSONObject) JSONObject.toJSON(json);
//		return json2Map(obj);
//	}

    /**
     * json2Map(Json字符串转Map)
     *
     * @param @param  json
     * @param @return
     * @return Map<String,Object>
     * @Exception 异常对象
     */
    public static Map<String, Object> json2Map(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map m = mapper.readValue(json, Map.class);
        return m;
    }

    /**
     *
     *
     * json2Map(Json对象转Map对象)
     *
     * @param @param  obj
     * @param @return
     * @return Map<String,Object>
     * @Exception 异常对象
     */
//	public static Map<String, Object> json2Map(JSONObject obj) {
//		Set<?> set = obj.keySet();
//		Map<String, Object> map = new HashMap<String, Object>(set.size());
//		for (Object key : obj.keySet()) {
//			Object value = obj.get(key);
//			if (value instanceof JSONArray) {
//				map.put(key.toString(), json2List((JSONArray) value));
//			} else if (value instanceof JSONObject) {
//				map.put(key.toString(), json2Map((JSONObject) value));
//			} else {
//				map.put(key.toString(), obj.get(key));
//			}
//
//		}
//		return map;
//	}

    /**
     * @Title: objectToString @Description: java类转json并加上类全路径名前缀 @param @param
     * object @param @param prefix @param @return @param @throws
     * JsonProcessingException 参数 @return String 返回类型 @throws
     */
    public static String objectToString(Object object, String prefix) throws JsonProcessingException {
        // 第1步：创建ObjectMapper对象。
        // 创建ObjectMapper对象。它是一个可重复使用的对象。
        ObjectMapper mapper = new ObjectMapper();
        // 第2步：序列化对象到JSON。
        // 使用writeValueAsString()方法来获取对象的JSON字符串表示。
        String jsonString = mapper.writeValueAsString(object);
        jsonString = prefix + " = " + jsonString;
        return jsonString;
    }

    /**
     * @Title: objectToString @Description: java类转json并加上类全路径名前缀 @param @param
     * object @param @param @return @param @throws JsonProcessingException
     * 参数 @return String 返回类型 @throws
     */
    public static String objectToJson(Object object) {
        // 第1步：创建ObjectMapper对象。
        // 创建ObjectMapper对象。它是一个可重复使用的对象。
        ObjectMapper mapper = new ObjectMapper();
        // 第2步：序列化对象到JSON。
        // 使用writeValueAsString()方法来获取对象的JSON字符串表示。
        String jsonString = "{}";
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;
    }

    /**
     * 	将对象转换成json字符串。设置日期格式
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJsonSetDateFormat(Object data) {
        try {
            //Jackson将对象转换为json字符串时，设置默认的时间格式
//            DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            ObjectMapper mapper = new ObjectMapper();
            // 设置时间格式
            mapper.setDateFormat(dateformat);
            // 序列化时忽略null
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            String string = mapper.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static <T> T jsonToObject(String json, Class<T> type) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, type);
    }

    /**
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static byte[] objectToBytes(Object object) throws JsonProcessingException {
        // 第1步：创建ObjectMapper对象。
        // 创建ObjectMapper对象。它是一个可重复使用的对象。
        ObjectMapper mapper = new ObjectMapper();
        // 第2步：序列化对象到JSON。
        // 使用writeValueAsString()方法来获取对象的JSON字符串表示。
        String jsonString = mapper.writeValueAsString(object);
        return jsonString.getBytes();
    }
}
