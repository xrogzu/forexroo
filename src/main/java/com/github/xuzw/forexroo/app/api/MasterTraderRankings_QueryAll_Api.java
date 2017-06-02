package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "交易大师排行榜 - 查询全部")
@GenerateByApiEngineSdk(time = "2017.06.02 06:48:22.179", version = "v0.0.16")
public class MasterTraderRankings_QueryAll_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "列表")
        @Required(value = true)
        private List<MasterTraderRankings> list;

        public List<MasterTraderRankings> getList() {
            return list;
        }

        public void setList(List<MasterTraderRankings> list) {
            this.list = list;
        }
    }
}
