package com.github.xuzw.forexroo.database.model;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月7日 上午10:34:16
 */
public enum MyBankCardStatusEnum {
    /**
     * 未绑定
     */
    not(0),
    /**
     * 绑定中
     */
    binding(1),
    /**
     * 绑定成功
     */
    binding_success(2),
    /**
     * 绑定失败
     */
    binding_fail(3);

    private int value;

    private MyBankCardStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
