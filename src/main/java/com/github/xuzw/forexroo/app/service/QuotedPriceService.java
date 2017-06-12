package com.github.xuzw.forexroo.app.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月12日 下午5:19:30
 */
public class QuotedPriceService {
    private static final Cache<String, String> bidCache = CacheBuilder.newBuilder().build();

    public static void putBid(String symbol, String value) {
        bidCache.put(symbol, value);
    }

    public static String getBidIfPresent(String symbol) {
        return bidCache.getIfPresent(symbol);
    }
}
