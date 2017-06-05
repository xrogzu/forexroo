package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.annotation.ModelAnnotation;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@ModelAnnotation()
@GenerateByApiEngineSdk(time = "2017.06.05 05:03:01.171", version = "v0.0.25")
public class MasterTraderRankings {

    @Comment(value = "用户ID")
    @Required(value = true)
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Comment(value = "头像")
    @Required(value = true)
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Comment(value = "昵称")
    @Required(value = true)
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Comment(value = "关注人数")
    @Required(value = true)
    private Long followerCount;

    public Long getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Long followerCount) {
        this.followerCount = followerCount;
    }

    @Comment(value = "总盈利")
    @Required(value = true)
    private String totalProfit;

    public String getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(String totalProfit) {
        this.totalProfit = totalProfit;
    }

    @Comment(value = "均单盈利")
    @Required(value = true)
    private String singleProfit;

    public String getSingleProfit() {
        return singleProfit;
    }

    public void setSingleProfit(String singleProfit) {
        this.singleProfit = singleProfit;
    }

    @Comment(value = "成功率")
    @Required(value = true)
    private String successRate;

    public String getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(String successRate) {
        this.successRate = successRate;
    }
}
