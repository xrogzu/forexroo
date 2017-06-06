package com.github.xuzw.forexroo.app.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.tables.daos.MasterTraderRankingsDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "交易大师排行榜 - 查询全部")
@GenerateByApiEngineSdk(time = "2017.06.06 10:17:24.069", version = "v0.0.28")
public class MasterTraderRankings_QueryAll_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        MasterTraderRankingsDao masterTraderRankingsDao = new MasterTraderRankingsDao(Jooq.buildConfiguration());
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);
        String time = new SimpleDateFormat("yyyy-MM-dd").format(yesterday.getTime());
        List<MasterTraderRankings> list = new ArrayList<>();
        for (com.github.xuzw.forexroo.entity.tables.pojos.MasterTraderRankings x : masterTraderRankingsDao.fetchByTime(time)) {
            User user = userDao.fetchOneById(x.getUserId());
            MasterTraderRankings rankings = new MasterTraderRankings();
            rankings.setUserId(user.getId());
            rankings.setAvatar(user.getAvatar());
            rankings.setNickname(user.getNickname());
            rankings.setFollowerCount(0L);
            rankings.setSingleProfit(x.getSingleProfit());
            rankings.setSuccessRate(x.getSuccessRate());
            rankings.setTotalProfit(x.getTotalProfit());
            list.add(rankings);
        }
        resp.setList(list);
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "列表") @Required(value = true) private List<MasterTraderRankings> list;

        public List<MasterTraderRankings> getList() {
            return list;
        }

        public void setList(List<MasterTraderRankings> list) {
            this.list = list;
        }
    }
}
