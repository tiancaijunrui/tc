package com.kotlin.zcj.tc.tiancai.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Since2018/1/2 ZhaCongJie@HF
 */
public class TcExecutionContext {
    /**
     * 用于保存线程相关信息
     */
    transient static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();
    private static final String USER_ID = "user_id";

    /**
     * 从 ThreadLocal中获取名值Map(不包含appCode)
     *
     * @return 名值Map
     */
    private static Map<String, String> getContextMap() {
        return threadLocal.get();
    }

    /**
     * 从 ThreadLocal 获取名值Map
     *
     * @param contextMap 名值Map
     */
    private static void setContextMap(Map<String, String> contextMap) {
        threadLocal.set(contextMap);
    }

    /**
     * （获取键下的值.如果不存在，返回null；如果名值Map未初始化，也返回null） Get the value of key. Would
     * return null if context map hasn't been initialized.
     *
     * @param key 键
     * @return 键下的值
     */
    public static String get(String key) {
        Map<String, String> contextMap = getContextMap();
        if (contextMap == null) {
            return null;
        }

        return contextMap.get(key);
    }

    /**
     * （设置名值对。如果Map之前为null，则会被初始化） Put the key-value into the context map;
     * <p/>
     * Initialize the map if the it doesn't exist.
     *
     * @param key   键
     * @param value 值
     * @return 之前的值
     */
    private static String put(String key, String value) {
        Map<String, String> contextMap = getContextMap();
        if (contextMap == null) {
            contextMap = new HashMap<String, String>();
            setContextMap(contextMap);
        }

        return contextMap.put(key, value);
    }

    public static String getUserId() {
        String userId = get(USER_ID);
        return userId != null && userId.length() > 0 ? userId : null;
    }

    public static void setUserId(String userId) {
        put(USER_ID, userId);
    }
}
