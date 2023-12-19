package com.korbiztech.product.cocs.COM.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class JsonUtil {

	@Autowired
    private ProfileChecker profileChecker;
	
	public String readJsonStringFromRequest(HttpServletRequest request) {
		var sb = new StringBuilder();
		String line;

		try (var reader = request.getReader()) {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			if (profileChecker.isDevProfileActive()) {
				e.printStackTrace();
			}
			return null;
		}
		return sb.toString();
	}

	public ResponseEntity<?> validateJsonString(String jsonString) {
        if (jsonString == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return null;
    }

	@SuppressWarnings("unchecked")
	public static <T> String sanitizeJson(String jsonString, Class<T> voClass) {
		Gson gson = new Gson();
		Map<String, Object> jsonMap = gson.fromJson(jsonString, Map.class);
		 Field[] fields = voClass.getDeclaredFields();
		 for (Field field : fields) {
			 String fieldName = field.getName();
			 Class<?> fieldType = field.getType();
			 if (jsonMap.containsKey(fieldName)) {
				 Object value = jsonMap.get(fieldName);
				 if ("".equals(value)) {
					 if (fieldType == int.class) {
						 jsonMap.put(fieldName, 0);
					 } else if (fieldType == long.class) {
						 jsonMap.put(fieldName, 0L);
					 } else if (fieldType == float.class) {
						 jsonMap.put(fieldName, 0.0f);
					 }
				 }
			 }
		 }
		 return gson.toJson(jsonMap);
	}
	
	public static <T> T convertAndSanitize(Object data, Class<T> targetClass) {
		Gson gson = new Gson();
	    String jsonData = gson.toJson(data);
	    String sanitizedData = JsonUtil.sanitizeJson(jsonData, targetClass);
	    return gson.fromJson(sanitizedData, targetClass);
	}

	@SuppressWarnings("rawtypes")
	public static <T> List<T> parseJsonToList(String jsonString, Class<T> voClass) {
		jsonString = jsonString.substring(1, jsonString.length() - 1);
		jsonString = jsonString.replace("\\\"", "\"");
		Type listType = new TypeToken<List<SaveGridDataVO>>() {}.getType();
		return new Gson().fromJson(jsonString, listType);
	}

	public static <T> List<T> parseJsonToList(String jsonString, Type type) {
		return new Gson().fromJson(jsonString, type);
	}
	
}
