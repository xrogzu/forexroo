package com.github.xuzw.forexroo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 下午1:26:36
 */
public class DateTimeUtils {
    private static String DEFAULT_TIMEZONE = "GMT+8";
    private static String DEFAULT_FORMAT = "d-MMM-yyyy HH:mm (z)";

    /**
     * 转换时间时区
     * 
     * @param convertString
     *            需要转的时间字符串
     * @param format
     *            格式话字符串 例如d-MMM-yyyy HH:mm (z)
     * @param sourceTimeZone
     *            源时间时区
     * @param targetTimeZone
     *            目标时间时区
     * @return
     * @throws ParseException
     */
    public static Date converTimeZone(String convertString, String format, String sourceTimeZone, String targetTimeZone) throws ParseException {
        if (isEmpty(sourceTimeZone)) {
            sourceTimeZone = DEFAULT_TIMEZONE;
        }
        if (isEmpty(targetTimeZone)) {
            targetTimeZone = DEFAULT_TIMEZONE;
        }
        if (isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // 获取传入的时间值
        Long time = new Date(sdf.parse(convertString).getTime()).getTime();
        // 获取源时区时间相对的GMT时间
        Long sourceRelativelyGMT = time - TimeZone.getTimeZone(sourceTimeZone).getRawOffset();
        // GMT时间+目标时间时区的偏移量获取目标时间
        Long targetTime = sourceRelativelyGMT + TimeZone.getTimeZone(targetTimeZone).getRawOffset();
        return new Date(targetTime);
    }

    private static boolean isEmpty(String value) {
        return StringUtils.isBlank(value);
    }

    public static void main(String[] args) throws Exception {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println(sdf.format(DateTimeUtils.converTimeZone("2017-06-06 13:31:35", format, "GMT+8", "GMT")));
    }
}
