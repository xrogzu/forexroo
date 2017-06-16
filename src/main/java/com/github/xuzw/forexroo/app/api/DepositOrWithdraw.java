package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.annotation.ModelAnnotation;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@ModelAnnotation()
@GenerateByApiEngineSdk(time = "2017.06.16 02:57:35.767", version = "v1.0.7")
public class DepositOrWithdraw {

    @Comment(value = "类型（1:入金 2:出金 3:增加信用 4:减少信用 101:佣金入金 102:分成入金 103:奖励入金）")
    @Required(value = true)
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Comment(value = "金额")
    @Required(value = true)
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Comment(value = "时间")
    @Required(value = true)
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
