package com.github.xuzw.forexroo.app.utils;

import java.util.UUID;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月31日 下午12:03:50
 */
public class Tokens {
    public static String newToken() {
        return UUID.randomUUID().toString();
    }
}
