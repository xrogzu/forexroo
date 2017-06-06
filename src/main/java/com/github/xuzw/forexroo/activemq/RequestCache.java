package com.github.xuzw.forexroo.activemq;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 上午11:08:11
 */
public class RequestCache {
    private final Cache<String, JsonResponseCallback> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();

    public void put(String requestId, JsonResponseCallback callback) {
        cache.put(requestId, callback);
    }

    public JsonResponseCallback getIfPresent(String requestId) {
        return cache.getIfPresent(requestId);
    }

    public String newRequestId() {
        return UUID.randomUUID().toString();
    }
}
