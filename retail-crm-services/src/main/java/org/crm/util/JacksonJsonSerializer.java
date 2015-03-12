package org.crm.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectWriter;

public class JacksonJsonSerializer {

	private static ObjectWriter objectWriter;

	private static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	/**
	 * 
	 * @param object
	 *            simple object which wants to be converted to be json string.
	 * @return json string.
	 */
	public static String toJson(Object object) {
		String jsonString = null;
		try {
			jsonString = objectWriter.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return jsonString;
		}
	}

	/**
	 * 
	 * @param json
	 *            json string.
	 * @param className
	 *            the name of the class.
	 * @param <T>
	 *            the type of the class.
	 * @return the object from the json string.
	 */
	public static <T> T fromJson(String json, Class<T> className) {
		T result=null;
		try {
			result = objectMapper.readValue(json, className);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.fasterxml.jackson.databind.JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return result;
		}
	}

}
