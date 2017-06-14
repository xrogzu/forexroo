package com.github.xuzw.forexroo.app.api;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.FeedbackDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.Feedback;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "用户 - 意见反馈")
@GenerateByApiEngineSdk(time = "2017.06.14 10:35:02.210", version = "v0.0.39")
public class User_Feedback_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        FeedbackDao feedbackDao = new FeedbackDao(Jooq.buildConfiguration());
        Feedback feedback = new Feedback();
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        if (user != null) {
            feedback.setUserId(user.getId());
        }
        feedback.setContent(req.getContent());
        feedback.setTime(System.currentTimeMillis());
        feedback.setPictureUrls(JSON.toJSONString(req.getPictureUrls()));
        feedbackDao.insert(feedback);
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

        @Comment(value = "意见反馈详细描述")
        @Required(value = true)
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Comment(value = "截图照片URL")
        @Required(value = true)
        private List<String> pictureUrls;

        public List<String> getPictureUrls() {
            return pictureUrls;
        }

        public void setPictureUrls(List<String> pictureUrls) {
            this.pictureUrls = pictureUrls;
        }
    }
}
