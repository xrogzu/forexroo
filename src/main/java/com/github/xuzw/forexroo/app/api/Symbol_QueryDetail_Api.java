package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "品种 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.05 12:08:44.868", version = "v0.0.22")
public class Symbol_QueryDetail_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
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
