package com.github.xuzw.forexroo.database.model;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月16日 上午10:48:43
 */
public enum BrokerRequestAuditFailReasonEnum implements NamedValue {
    unknown(0, "未知"), sign_not_clear(1, "签名不清晰");

    private int value;
    private String comment;

    private BrokerRequestAuditFailReasonEnum(int value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getComment() {
        return comment;
    }
}
