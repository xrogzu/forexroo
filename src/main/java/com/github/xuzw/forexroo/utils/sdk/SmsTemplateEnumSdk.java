package com.github.xuzw.forexroo.utils.sdk;

import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月25日 下午6:04:42
 */
public class SmsTemplateEnumSdk {
    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream("doc/sms.template.txt");
        List<String> lines = IOUtils.readLines(input, Charset.forName("utf8"));
        lines.remove(0);
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            System.out.println(String.format("tpl_%s(%s, \"%s\"), // 短信模板%s", parts[0], parts[0], parts[1], parts[0]));
        }
        IOUtils.closeQuietly(input);
    }
}
