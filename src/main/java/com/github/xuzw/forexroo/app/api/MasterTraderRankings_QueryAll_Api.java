package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.util.ArrayList;
import java.util.List;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "交易大师排行榜 - 查询全部")
@GenerateByApiEngineSdk(time = "2017.06.07 11:16:34.718", version = "v0.0.31")
public class MasterTraderRankings_QueryAll_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        List<User> users = DSL.using(Jooq.buildConfiguration()).selectFrom(USER).orderBy(USER.MASTER_TRADER_TOTAL_PROFIT).limit(10).fetch().into(User.class);
        List<MasterTraderRankings> list = new ArrayList<>();
        for (User user : users) {
            MasterTraderRankings rankings = new MasterTraderRankings();
            rankings.setUserId(user.getId());
            rankings.setAvatar(user.getAvatar());
            rankings.setNickname(user.getNickname());
            rankings.setFollowerCount(0L);
            rankings.setSingleProfit(user.getMasterTraderSingleProfit());
            rankings.setSuccessRate(user.getMasterTraderSuccessRate());
            rankings.setTotalProfit(user.getMasterTraderTotalProfit());
            list.add(rankings);
        }
        resp.setList(list);
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
