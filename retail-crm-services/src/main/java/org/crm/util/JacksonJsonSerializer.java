package org.crm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

import java.io.IOException;

public class JacksonJsonSerializer {

    private static ObjectWriter objectWriter;

    private static ObjectMapper objectMapper;
    
    private static Hibernate4Module hibernate4Module;

    static {
        objectMapper = new ObjectMapper();
        hibernate4Module = new Hibernate4Module();
        hibernate4Module.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
        objectMapper.registerModule(hibernate4Module);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }

    /**
     * @param object simple object which wants to be converted to be json string.
     * @return json string.
     */
    public static String toJson(Object object) {
        String jsonString = null;
        try {
            jsonString = objectWriter.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return jsonString;
        }
    }

    /**
     * @param json      json string.
     * @param className the name of the class.
     * @param <T>       the type of the class.
     * @return the object from the json string.
     */
    public static <T> T fromJson(String json, Class<T> className) {
        T result = null;
        try {
            result = objectMapper.readValue(json, className);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

}
