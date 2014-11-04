package com.chaoshike.shop.resource.necessity;

import java.util.HashMap;
import java.util.Map;


public class TestBeans {
    private static Map<Class<?>, Object> mocksByClass = new HashMap<Class<?>, Object>();
    private static Map<String, Object> mocksByName = new HashMap<String, Object>();

    public static <T> void replaceBean(Class<T> clazz, Object mock) {
        mocksByClass.put(clazz, mock);
    }

    public static <T> void replaceBean(String name, Object mock) {
        mocksByName.put(name, mock);
    }

    public static void reset() {
        mocksByClass.clear();
        mocksByName.clear();
    }

    public static <T> Object get(Class<T> requiredType) {
        return mocksByClass.get(requiredType);
    }

    public static Object get(String name) {
        return mocksByName.get(name);
    }
}
