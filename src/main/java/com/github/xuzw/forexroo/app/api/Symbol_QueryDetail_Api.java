package com.github.xuzw.forexroo.app.api;

import java.text.NumberFormat;
import java.util.Calendar;
import com.alibaba.fastjson.JSONObject;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.activemq.ActiveMq;
import com.github.xuzw.forexroo.app.service.Mt4MiddlewareService;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "品种 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.12 12:45:53.892", version = "v0.0.36")
public class Symbol_QueryDetail_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String symbol = req.getSymbol();
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("symbol", symbol);
        jsonRequest.put("period", 1440);
        Calendar fromTime = Calendar.getInstance();
        fromTime.add(Calendar.HOUR_OF_DAY, -8);
        jsonRequest.put("fromtime", fromTime.getTimeInMillis() / 1000);
        jsonRequest.put("endtime", fromTime.getTimeInMillis() / 1000);
        JSONObject historyRatesjsonResponse = ActiveMq.sendRequestAndAwait("History_Rates_Info_Topic", jsonRequest);
        JSONObject rateinfo = historyRatesjsonResponse.getJSONArray("rateinfos").getJSONObject(0);
        double close = rateinfo.getDoubleValue("open") + rateinfo.getDoubleValue("close");
        double last = Mt4MiddlewareService.getTickLast(symbol).getDoubleValue("bid");
        Resp resp = new Resp();
        resp.setChange(String.valueOf(last - close));
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
        resp.setChg(nt.format(Double.valueOf(last - close) / close));
        resp.setTime(String.valueOf(System.currentTimeMillis()));
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "品种")
        @Required(value = true)
        private String symbol;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "涨跌点数")
        @Required(value = true)
        private String change;

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }

        @Comment(value = "涨跌幅度")
        @Required(value = true)
        private String chg;

        public String getChg() {
            return chg;
        }

        public void setChg(String chg) {
            this.chg = chg;
        }

        @Comment(value = "当前时间")
        @Required(value = true)
        private String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
