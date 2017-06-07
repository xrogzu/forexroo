package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "交易大师排行榜 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.07 04:22:25.065", version = "v0.0.33")
public class MasterTraderRankings_QueryDetail_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "交易大师ID")
        @Required(value = true)
        private Long userId;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "日图（最近24日，不包含本日）")
        @Required(value = true)
        private List<MasterTraderProfit> dailyReportList;

        public List<MasterTraderProfit> getDailyReportList() {
            return dailyReportList;
        }

        public void setDailyReportList(List<MasterTraderProfit> dailyReportList) {
            this.dailyReportList = dailyReportList;
        }

        @Comment(value = "周图（最近24周，不包含本周）")
        @Required(value = true)
        private List<MasterTraderProfit> weeklyReportList;

        public List<MasterTraderProfit> getWeeklyReportList() {
            return weeklyReportList;
        }

        public void setWeeklyReportList(List<MasterTraderProfit> weeklyReportList) {
            this.weeklyReportList = weeklyReportList;
        }

        @Comment(value = "月图（最近24月，不包含本月）")
        @Required(value = true)
        private List<MasterTraderProfit> monthlyReportList;

        public List<MasterTraderProfit> getMonthlyReportList() {
            return monthlyReportList;
        }

        public void setMonthlyReportList(List<MasterTraderProfit> monthlyReportList) {
            this.monthlyReportList = monthlyReportList;
        }
    }
}
