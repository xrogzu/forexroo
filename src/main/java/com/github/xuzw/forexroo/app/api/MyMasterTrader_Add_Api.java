package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
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

@Comment(value = "我关注的交易大师 - 添加")
@GenerateByApiEngineSdk(time = "2017.06.07 11:16:34.756", version = "v0.0.31")
public class MyMasterTrader_Add_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        MyMasterTraderDao myMasterTraderDao = new MyMasterTraderDao(Jooq.buildConfiguration());
        MyMasterTrader myMasterTrader = new MyMasterTrader();
        myMasterTrader.setUserId(user.getId());
        myMasterTrader.setTime(System.currentTimeMillis());
        myMasterTrader.setMasterTraderUserId(req.getMasterTraderUserId());
        myMasterTraderDao.insert(myMasterTrader);
        return new Response();
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

        @Comment(value = "交易大师ID")
        @Required(value = true)
        private Long masterTraderUserId;

        public Long getMasterTraderUserId() {
            return masterTraderUserId;
        }

        public void setMasterTraderUserId(Long masterTraderUserId) {
            this.masterTraderUserId = masterTraderUserId;
        }
    }
}
