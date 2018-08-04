package org.sang.demo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

/**
 * jackson工具类
 *
 * @author Angle
 * @date 2017/4/15
 */
public class JsonUtil {
	
    private static final class ObjectMapperBuild {

        private static final ObjectMapper MAPPER = new ObjectMapper();

        static {
            //设置可用单引号
            MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            //设置字段可以不用双引号包括
            MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            //设置时间格式
            MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            //忽略未找到字段
            MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

    }

    private static ObjectMapper getInstance() {
        return ObjectMapperBuild.MAPPER;
    }

    /**
     * 实体对象转换成Json字符串
     * @param t 实体对象T
     * @return Json字符串
     */
    public static <T> String objectToJson(T t) {

        try {
            return getInstance().writeValueAsString(t);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    
    public static Map<String, Object> objToMap(Object t) {
    	return jsonToObject(objectToJson(t), Map.class);
    }
    
    /**
     * Json字符串转换成实体对象
     * @param json Json字符串
     * @param type 实体对象所属类type
     * @return 实体类对象
     */
    public static <T> T jsonToObject(String json, Type type) {
    	try {
	    	JavaType jtype = null;
	    	if(type instanceof ParameterizedType) {
	    		ParameterizedType temp = (ParameterizedType)type;
	    		Type[] params = temp.getActualTypeArguments();
	    		jtype = getInstance().getTypeFactory().constructParametricType((Class)temp.getRawType(), (Class<T>) params[0]);
	    	} else {
	    		return getInstance().readValue(json, (Class<T>) type);
	    	}
			return getInstance().readValue(json, jtype);
		} catch (Exception e) {
            return null;
		}
    	
    }

    /**
     * Json字符串转换成实体对象
     * @param json Json字符串
     * @param clazz 实体对象所属类Class
     * @return 实体类对象
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            return getInstance().readValue(json, clazz);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Json字符串转换成List
     * @param json Json字符串
     * @param clazz 实体对象所属类Class
     * @return List对象，返回类型其实是ArrayList
     */
    public static <T> T jsonToList(String json, Class<T> clazz) {

        try {
            JavaType javaType = getInstance().getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return getInstance().readValue(json, javaType);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Json字符串转换成List
     * @param json json字符串
     * @param typeReference TypeReference<T>
     * <p>
     *  <pre>new TypeReference<List<User>>() {}</pre>
     * </p>
     * @return List对象
     */
    public static <T> T jsonToList(String json, TypeReference<T> typeReference) {

        try {
            return getInstance().readValue(json, typeReference);
        } catch (Exception e) {
            return null;
        }
    }
}
