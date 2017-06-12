package com.github.xuzw.forexroo.database.model;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月12日 下午12:06:40
 */
public enum DepositAndWithdrawTypeEnum {
    /**
     * 入金
     */
    deposit(1),
    /**
     * 出金
     */
    withdraw(2),
    /**
     * 增加信用
     */
    increase_credit(3),
    /**
     * 减少信用
     */
    reduce_credit(4),
    /**
     * 佣金入金
     */
    commission_deposit(101),
    /**
     * 分享入金
     */
    share_deposit(102),
    /**
     * 奖励入金
     */
    reward_deposit(103);

    private int value;

    private DepositAndWithdrawTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
