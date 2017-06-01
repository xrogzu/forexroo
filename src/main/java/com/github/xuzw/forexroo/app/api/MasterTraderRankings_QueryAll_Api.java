package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.github.xuzw.forexroo.entity.tables.pojos.MasterTraderRankings;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@GenerateByApiEngineSdk(time = "2017.06.01 06:39:45.578", version = "v0.0.7")
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
