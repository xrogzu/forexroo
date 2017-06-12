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
@GenerateByApiEngineSdk(time = "2017.06.12 12:45:53.732", version = "v0.0.36")
public class User_QueryProfile_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        Resp resp = new Resp();
        resp.setRegisterTime(user.getRegisterTime());
        resp.setAvatar(user.getAvatar());
        resp.setNickname(user.getNickname());
        resp.setSex(user.getSex());
        resp.setCountry(user.getCountry());
        resp.setOpenAccountRealname(user.getOpenAccountRealname());
        resp.setOpenAccountIdentityCardNumber(user.getOpenAccountIdentityCardNumber());
        resp.setOpenAccountPictureUrl(user.getOpenAccountPictureUrl());
        resp.setOpenAccountAgreements(user.getOpenAccountAgreements());
        resp.setOpenAccountSignUrl(user.getOpenAccountSignUrl());
        resp.setOpenAccountStatus(user.getOpenAccountStatus());
        resp.setBrokerRequestAgreements(user.getBrokerRequestAgreements());
        resp.setBrokerRequestSignUrl(user.getBrokerRequestSignUrl());
        resp.setBrokerRequestStatus(user.getBrokerRequestStatus());
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

        @Comment(value = "注册时间")
        @Required(value = true)
        private Long registerTime;

        public Long getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(Long registerTime) {
            this.registerTime = registerTime;
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

        @Comment(value = "开户-姓名")
        @Required(value = true)
        private String openAccountRealname;

        public String getOpenAccountRealname() {
            return openAccountRealname;
        }

        public void setOpenAccountRealname(String openAccountRealname) {
            this.openAccountRealname = openAccountRealname;
        }

        @Comment(value = "开户-身份证号")
        @Required(value = true)
        private String openAccountIdentityCardNumber;

        public String getOpenAccountIdentityCardNumber() {
            return openAccountIdentityCardNumber;
        }

        public void setOpenAccountIdentityCardNumber(String openAccountIdentityCardNumber) {
            this.openAccountIdentityCardNumber = openAccountIdentityCardNumber;
        }

        @Comment(value = "开户-手持身份证正面照URL")
        @Required(value = true)
        private String openAccountPictureUrl;

        public String getOpenAccountPictureUrl() {
            return openAccountPictureUrl;
        }

        public void setOpenAccountPictureUrl(String openAccountPictureUrl) {
            this.openAccountPictureUrl = openAccountPictureUrl;
        }

        @Comment(value = "开户-签订协议")
        @Required(value = true)
        private String openAccountAgreements;

        public String getOpenAccountAgreements() {
            return openAccountAgreements;
        }

        public void setOpenAccountAgreements(String openAccountAgreements) {
            this.openAccountAgreements = openAccountAgreements;
        }

        @Comment(value = "开户-签名图片URL")
        @Required(value = true)
        private String openAccountSignUrl;

        public String getOpenAccountSignUrl() {
            return openAccountSignUrl;
        }

        public void setOpenAccountSignUrl(String openAccountSignUrl) {
            this.openAccountSignUrl = openAccountSignUrl;
        }

        @Comment(value = "开户-状态")
        @Required(value = true)
        private Integer openAccountStatus;

        public Integer getOpenAccountStatus() {
            return openAccountStatus;
        }

        public void setOpenAccountStatus(Integer openAccountStatus) {
            this.openAccountStatus = openAccountStatus;
        }

        @Comment(value = "经纪人申请-签订协议")
        @Required(value = true)
        private String brokerRequestAgreements;

        public String getBrokerRequestAgreements() {
            return brokerRequestAgreements;
        }

        public void setBrokerRequestAgreements(String brokerRequestAgreements) {
            this.brokerRequestAgreements = brokerRequestAgreements;
        }

        @Comment(value = "经纪人申请-签名图片URL")
        @Required(value = true)
        private String brokerRequestSignUrl;

        public String getBrokerRequestSignUrl() {
            return brokerRequestSignUrl;
        }

        public void setBrokerRequestSignUrl(String brokerRequestSignUrl) {
            this.brokerRequestSignUrl = brokerRequestSignUrl;
        }

        @Comment(value = "经纪人申请-状态")
        @Required(value = true)
        private Integer brokerRequestStatus;

        public Integer getBrokerRequestStatus() {
            return brokerRequestStatus;
        }

        public void setBrokerRequestStatus(Integer brokerRequestStatus) {
            this.brokerRequestStatus = brokerRequestStatus;
        }
    }
}
