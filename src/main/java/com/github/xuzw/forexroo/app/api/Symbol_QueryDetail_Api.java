package com.github.xuzw.forexroo.app.api;

import java.util.Calendar;

import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "品种 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.06 10:17:24.061", version = "v0.0.28")
public class Symbol_QueryDetail_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("symbol", req.getSymbol());
        jsonRequest.put("period", 1440);
        Calendar fromTime = Calendar.getInstance();
        fromTime.add(Calendar.DAY_OF_MONTH, -1);
        fromTime.set(Calendar.HOUR_OF_DAY, 8 - 8);
        fromTime.set(Calendar.MINUTE, 0);
        fromTime.set(Calendar.SECOND, 0);
        fromTime.set(Calendar.MILLISECOND, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.add(Calendar.DAY_OF_MONTH, -1);
        endTime.set(Calendar.HOUR_OF_DAY, 18 - 8);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.SECOND, 0);
        endTime.set(Calendar.MILLISECOND, 0);
        jsonRequest.put("fromtime", fromTime.getTimeInMillis());
        jsonRequest.put("endtime", endTime.getTimeInMillis());
        JSONObject jsonResponse = ActiveMq.sendRequestAndAwait("History_Rates_Info_Topic", jsonRequest);
        Integer close = jsonResponse.getJSONArray("rateinfos").getJSONObject(0).getInteger("close");
        Resp resp = new Resp();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "品种") @Required(value = true) private String symbol;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "涨跌点数") @Required(value = true) private String change;

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }

        @Comment(value = "涨跌幅度") @Required(value = true) private String chg;

        public String getChg() {
            return chg;
        }

        public void setChg(String chg) {
            this.chg = chg;
        }

        @Comment(value = "当前时间") @Required(value = true) private String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
