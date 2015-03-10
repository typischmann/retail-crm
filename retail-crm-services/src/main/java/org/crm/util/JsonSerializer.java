package org.crm.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Dachuan Zhao on 2015/3/9.
 * Utility class which can be used by any classes across projects.
 */
public class JsonSerializer {
    private static final GsonBuilder gsonBuilder;
    private static final Gson GSON;

    // initialize the json engine.
    // in the future, if we have the complex object needs customize serialization, we need
    // to add type register here.
    static
    {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        GSON = gsonBuilder.create();
    }

    /**
     *
     * @param object simple object which wants to be converted to be json string.
     * @return json string.
     */
    public static String toJson(Object object)
    {
        return GSON.toJson(object);
    }

    /**
     *
     * @param json json string.
     * @param className the name of the class.
     * @param <T> the type of the class.
     * @return the object from the json string.
     */
    public static <T>T fromJson(String json, Class<T> className)
    {
        T result = GSON.fromJson(json, className);
        return result;
    }
}
