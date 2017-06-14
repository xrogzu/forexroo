package com.github.xuzw.forexroo.sdk;

import com.github.xuzw.forexroo.database.model.NamedValue;
import com.github.xuzw.forexroo.database.model.NamedValues;
import com.github.xuzw.forexroo.database.model.OpenAccountStatusEnum;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月14日 下午12:49:16
 */
public class NamedValueEnumSdk {
    public static void main(String[] args) {
        System.out.println(NamedValues.toText(OpenAccountStatusEnum.values()));
        System.out.println(toJs(OpenAccountStatusEnum.values()));
    }

    public static String toJs(Enum<? extends NamedValue>[] namedValues) {
        StringBuffer sb = new StringBuffer();
        sb.append("switch (data) {\n");
        for (Enum<? extends NamedValue> x : namedValues) {
            NamedValue namedValue = (NamedValue) x;
            sb.append(String.format("case %d: return '%s';\n", namedValue.getValue(), namedValue.getComment()));
        }
        sb.append("}");
        return sb.toString();
    }
}
