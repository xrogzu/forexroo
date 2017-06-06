package com.github.xuzw.forexroo.database.model;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月6日 上午10:39:12
 */
public enum OpenAccountStatusEnum {
    /**
     * 未开户
     */
    not(0),
    /**
     * 开户中
     */
    opening(1),
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

    private OpenAccountStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
