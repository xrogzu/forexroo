package com.github.xuzw.forexroo.app.api;

import java.util.ArrayList;
import java.util.List;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.DepositAndWithdrawDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.DepositAndWithdraw;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "出入金 - 查询列表")
@GenerateByApiEngineSdk(time = "2017.06.15 03:28:54.218", version = "v1.0.4")
public class DepositAndWithdraw_QueryList_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        DepositAndWithdrawDao depositAndWithdrawDao = new DepositAndWithdrawDao(Jooq.buildConfiguration());
        List<DepositOrWithdraw> list = new ArrayList<>();
        for (DepositAndWithdraw x : depositAndWithdrawDao.fetchByUserId(user.getId())) {
            DepositOrWithdraw model = new DepositOrWithdraw();
            model.setAmount(x.getAmount());
            model.setTime(x.getTime());
            model.setType(x.getType());
            list.add(model);
        }
        Resp resp = new Resp();
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
        private List<DepositOrWithdraw> list;

        public List<DepositOrWithdraw> getList() {
            return list;
        }

        public void setList(List<DepositOrWithdraw> list) {
            this.list = list;
        }
    }
}
