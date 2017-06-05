package com.github.xuzw.forexroo.app.utils;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月5日 下午5:21:32
 */
public class SmsVerificationCodeCache {
    private static final Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();

    public static void put(String phone, String type, String value) {
        cache.put(key(phone, type), value);
    }

    public static String getIfPresent(String phone, String type) {
        return cache.getIfPresent(key(phone, type));
    }

    private static String key(String phone, String type) {
        return phone + "#" + type;
    }
}
