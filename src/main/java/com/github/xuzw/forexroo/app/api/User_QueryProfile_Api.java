package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "用户 - 查询个人信息详情")
@GenerateByApiEngineSdk(time = "2017.06.07 09:51:37.968", version = "v0.0.30")
public class User_QueryProfile_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        Resp resp = new Resp();
        resp.setAvatar(user.getAvatar());
        resp.setNickname(user.getNickname());
        resp.setSex(user.getSex());
        resp.setCountry(user.getCountry());
        resp.setRealName(user.getOpenAccountRealname());
        resp.setIdentityCardNumber(user.getOpenAccountIdentityCardNumber());
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

        @Comment(value = "头像")
        @Required(value = true)
        private String avatar;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Comment(value = "昵称")
        @Required(value = true)
        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        @Comment(value = "性别")
        @Required(value = true)
        private String sex;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Comment(value = "国家")
        @Required(value = true)
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Comment(value = "姓名")
        @Required(value = true)
        private String realName;

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        @Comment(value = "身份证号")
        @Required(value = true)
        private String identityCardNumber;

        public String getIdentityCardNumber() {
            return identityCardNumber;
        }

        public void setIdentityCardNumber(String identityCardNumber) {
            this.identityCardNumber = identityCardNumber;
        }
    }
}
