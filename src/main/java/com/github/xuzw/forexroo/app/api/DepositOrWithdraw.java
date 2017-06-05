package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.annotation.ModelAnnotation;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@ModelAnnotation()
@GenerateByApiEngineSdk(time = "2017.06.05 05:52:49.249", version = "v0.0.27")
public class DepositOrWithdraw {

    @Comment(value = "类型（1:出金 2:入金 3:佣金入金 4:分享入金 5:奖励入金）")
    @Required(value = true)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
