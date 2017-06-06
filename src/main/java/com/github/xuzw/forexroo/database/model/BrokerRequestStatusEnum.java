package com.github.xuzw.forexroo.database.model;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 上午10:56:49
 */
public enum BrokerRequestStatusEnum {
    /**
     * 未申请
     */
    not(0),
    /**
     * 申请中
     */
    requesting(1),
    /**
     * 审核中
     */
    auditing(2),
    /**
     * 审核成功
     */
    auditing_success(3),
    /**
     * 审核失败
     */
    auditing_fail(4);

    private int value;

    private BrokerRequestStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
