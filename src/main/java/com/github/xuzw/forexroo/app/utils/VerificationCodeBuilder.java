package com.github.xuzw.forexroo.app.utils;

import java.util.Random;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月5日 下午5:26:41
 */
public class VerificationCodeBuilder {
    private static final char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static final int length = 4;

    public static String build() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars[new Random().nextInt(chars.length)]);
        }
        return sb.toString();
    }
}
