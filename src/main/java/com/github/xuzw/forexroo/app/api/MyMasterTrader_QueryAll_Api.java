package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.util.ArrayList;
import java.util.List;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.tables.daos.MyMasterTraderDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.MyMasterTrader;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "我关注的交易大师 - 查询列表")
@GenerateByApiEngineSdk(time = "2017.06.07 09:51:38.124", version = "v0.0.30")
public class MyMasterTrader_QueryAll_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        MyMasterTraderDao myMasterTraderDao = new MyMasterTraderDao(Jooq.buildConfiguration());
        List<MyMasterTrader> myMasterTraders = myMasterTraderDao.fetchByUserId(user.getId());
        Resp resp = new Resp();
        List<MasterTraderRankings> list = new ArrayList<>();
        for (MyMasterTrader x : myMasterTraders) {
            User masterTrader = userDao.fetchOneById(x.getMasterTraderUserId());
            MasterTraderRankings rankings = new MasterTraderRankings();
            rankings.setUserId(masterTrader.getId());
            rankings.setAvatar(masterTrader.getAvatar());
            rankings.setNickname(masterTrader.getNickname());
            rankings.setFollowerCount(0L);
            rankings.setSingleProfit(user.getMasterTraderSingleProfit());
            rankings.setSuccessRate(user.getMasterTraderSuccessRate());
            rankings.setTotalProfit(user.getMasterTraderTotalProfit());
            list.add(rankings);
        }
        resp.setList(list);
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "用户唯一标识码")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
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
