package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Field;
import org.jooq.impl.DSL;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "用户 - 修改个人信息")
@GenerateByApiEngineSdk(time = "2017.06.07 09:29:15.836", version = "v0.0.29")
public class User_UpdateProfile_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        String token = req.getToken();
        Map<Field<?>, Object> map = new HashMap<>();
        if (StringUtils.isNoneBlank(req.getAvatar())) {
            map.put(USER.AVATAR, req.getAvatar());
        }
        if (StringUtils.isNoneBlank(req.getNickname())) {
            map.put(USER.NICKNAME, req.getNickname());
        }
        if (StringUtils.isNoneBlank(req.getSex())) {
            map.put(USER.SEX, req.getSex());
        }
        if (StringUtils.isNoneBlank(req.getCountry())) {
            map.put(USER.COUNTRY, req.getCountry());
        }
        DSL.using(Jooq.buildConfiguration()).update(USER).set(map).where(USER.TOKEN.equal(token)).execute();
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
    }
}
