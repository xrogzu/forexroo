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
@GenerateByApiEngineSdk(time = "2017.06.16 10:50:20.215", version = "v1.0.6")
public class User_QueryProfile_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(Tables.USER.TOKEN, req.getToken());
        Resp resp = new Resp();
        resp.setIsDisable(user.getIsDisable());
        resp.setIsClosing(user.getIsClosing());
        resp.setRegisterTime(user.getRegisterTime());
        resp.setAvatar(user.getAvatar());
        resp.setNickname(user.getNickname());
        resp.setSex(user.getSex());
        resp.setCountry(user.getCountry());
        resp.setMyBrokerId(user.getMyBrokerId());
        resp.setMyBrokerName(user.getMyBrokerName());
        resp.setMyAgentId(user.getMyAgentId());
        resp.setMyAgentName(user.getMyAgentName());
        resp.setOpenAccountRealname(user.getOpenAccountRealname());
        resp.setOpenAccountIdentityCardNumber(user.getOpenAccountIdentityCardNumber());
        resp.setOpenAccountPictureUrl(user.getOpenAccountPictureUrl());
        resp.setOpenAccountAgreements(user.getOpenAccountAgreements());
        resp.setOpenAccountSignUrl(user.getOpenAccountSignUrl());
        resp.setOpenAccountStatus(user.getOpenAccountStatus());
        resp.setOpenAccountAuditUserId(user.getOpenAccountAuditUserId());
        resp.setOpenAccountAuditUserName(user.getOpenAccountAuditUserName());
        resp.setOpenAccountAuditTimestamp(user.getOpenAccountAuditTimestamp());
        resp.setOpenAccountAuditFailReason(user.getOpenAccountAuditFailReason());
        resp.setOpenAccountTime(user.getOpenAccountTime());
        resp.setOpenAccountAuditSuccessTime(user.getOpenAccountAuditSuccessTime());
        resp.setBrokerRequestAgreements(user.getBrokerRequestAgreements());
        resp.setBrokerRequestSignUrl(user.getBrokerRequestSignUrl());
        resp.setBrokerRequestStatus(user.getBrokerRequestStatus());
        resp.setBrokerRequestAuditUserId(user.getBrokerRequestAuditUserId());
        resp.setBrokerRequestAuditUserName(user.getBrokerRequestAuditUserName());
        resp.setBrokerRequestAuditTimestamp(user.getBrokerRequestAuditTimestamp());
        resp.setBrokerRequestAuditFailReason(user.getBrokerRequestAuditFailReason());
        resp.setBrokerRequestTime(user.getBrokerRequestTime());
        resp.setBrokerRequestAuditSuccessTime(user.getBrokerRequestAuditSuccessTime());
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

        @Comment(value = "是否禁用（0:否 1:是）")
        @Required(value = true)
        private Integer isDisable;

        public Integer getIsDisable() {
            return isDisable;
        }

        public void setIsDisable(Integer isDisable) {
            this.isDisable = isDisable;
        }

        @Comment(value = "是否销户（0:否 1:是）")
        @Required(value = true)
        private Integer isClosing;

        public Integer getIsClosing() {
            return isClosing;
        }

        public void setIsClosing(Integer isClosing) {
            this.isClosing = isClosing;
        }

        @Comment(value = "注册时间戳")
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

        @Comment(value = "所属经纪人-ID")
        @Required(value = true)
        private Long myBrokerId;

        public Long getMyBrokerId() {
            return myBrokerId;
        }

        public void setMyBrokerId(Long myBrokerId) {
            this.myBrokerId = myBrokerId;
        }

        @Comment(value = "所属经纪人-姓名")
        @Required(value = true)
        private String myBrokerName;

        public String getMyBrokerName() {
            return myBrokerName;
        }

        public void setMyBrokerName(String myBrokerName) {
            this.myBrokerName = myBrokerName;
        }

        @Comment(value = "所属代理商-ID")
        @Required(value = true)
        private Long myAgentId;

        public Long getMyAgentId() {
            return myAgentId;
        }

        public void setMyAgentId(Long myAgentId) {
            this.myAgentId = myAgentId;
        }

        @Comment(value = "所属代理商-姓名")
        @Required(value = true)
        private String myAgentName;

        public String getMyAgentName() {
            return myAgentName;
        }

        public void setMyAgentName(String myAgentName) {
            this.myAgentName = myAgentName;
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

        @Comment(value = "开户-状态（0:未开户 1:审核中 2:审核成功 3:审核失败）")
        @Required(value = true)
        private Integer openAccountStatus;

        public Integer getOpenAccountStatus() {
            return openAccountStatus;
        }

        public void setOpenAccountStatus(Integer openAccountStatus) {
            this.openAccountStatus = openAccountStatus;
        }

        @Comment(value = "开户-审核人-ID")
        @Required(value = true)
        private Long openAccountAuditUserId;

        public Long getOpenAccountAuditUserId() {
            return openAccountAuditUserId;
        }

        public void setOpenAccountAuditUserId(Long openAccountAuditUserId) {
            this.openAccountAuditUserId = openAccountAuditUserId;
        }

        @Comment(value = "开户-审核人-姓名")
        @Required(value = true)
        private String openAccountAuditUserName;

        public String getOpenAccountAuditUserName() {
            return openAccountAuditUserName;
        }

        public void setOpenAccountAuditUserName(String openAccountAuditUserName) {
            this.openAccountAuditUserName = openAccountAuditUserName;
        }

        @Comment(value = "开户-审核时间戳")
        @Required(value = true)
        private Long openAccountAuditTimestamp;

        public Long getOpenAccountAuditTimestamp() {
            return openAccountAuditTimestamp;
        }

        public void setOpenAccountAuditTimestamp(Long openAccountAuditTimestamp) {
            this.openAccountAuditTimestamp = openAccountAuditTimestamp;
        }

        @Comment(value = "开户-审核失败-原因（0:未知 1:手持身份证照不清晰 2:签名不清晰）")
        @Required(value = true)
        private Integer openAccountAuditFailReason;

        public Integer getOpenAccountAuditFailReason() {
            return openAccountAuditFailReason;
        }

        public void setOpenAccountAuditFailReason(Integer openAccountAuditFailReason) {
            this.openAccountAuditFailReason = openAccountAuditFailReason;
        }

        @Comment(value = "开户-申请时间戳")
        @Required(value = true)
        private Long openAccountTime;

        public Long getOpenAccountTime() {
            return openAccountTime;
        }

        public void setOpenAccountTime(Long openAccountTime) {
            this.openAccountTime = openAccountTime;
        }

        @Comment(value = "开户-审核通过时间戳")
        @Required(value = true)
        private Long openAccountAuditSuccessTime;

        public Long getOpenAccountAuditSuccessTime() {
            return openAccountAuditSuccessTime;
        }

        public void setOpenAccountAuditSuccessTime(Long openAccountAuditSuccessTime) {
            this.openAccountAuditSuccessTime = openAccountAuditSuccessTime;
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

        @Comment(value = "经纪人申请-状态（0:未申请 1:审核中 2:审核成功 3:审核失败）")
        @Required(value = true)
        private Integer brokerRequestStatus;

        public Integer getBrokerRequestStatus() {
            return brokerRequestStatus;
        }

        public void setBrokerRequestStatus(Integer brokerRequestStatus) {
            this.brokerRequestStatus = brokerRequestStatus;
        }

        @Comment(value = "经纪人申请-审核人-ID")
        @Required(value = true)
        private Long brokerRequestAuditUserId;

        public Long getBrokerRequestAuditUserId() {
            return brokerRequestAuditUserId;
        }

        public void setBrokerRequestAuditUserId(Long brokerRequestAuditUserId) {
            this.brokerRequestAuditUserId = brokerRequestAuditUserId;
        }

        @Comment(value = "经纪人申请-审核人-姓名")
        @Required(value = true)
        private String brokerRequestAuditUserName;

        public String getBrokerRequestAuditUserName() {
            return brokerRequestAuditUserName;
        }

        public void setBrokerRequestAuditUserName(String brokerRequestAuditUserName) {
            this.brokerRequestAuditUserName = brokerRequestAuditUserName;
        }

        @Comment(value = "经纪人申请-审核时间戳")
        @Required(value = true)
        private Long brokerRequestAuditTimestamp;

        public Long getBrokerRequestAuditTimestamp() {
            return brokerRequestAuditTimestamp;
        }

        public void setBrokerRequestAuditTimestamp(Long brokerRequestAuditTimestamp) {
            this.brokerRequestAuditTimestamp = brokerRequestAuditTimestamp;
        }

        @Comment(value = "经纪人申请-审核失败-原因（0:未知 1:签名不清晰）")
        @Required(value = true)
        private Integer brokerRequestAuditFailReason;

        public Integer getBrokerRequestAuditFailReason() {
            return brokerRequestAuditFailReason;
        }

        public void setBrokerRequestAuditFailReason(Integer brokerRequestAuditFailReason) {
            this.brokerRequestAuditFailReason = brokerRequestAuditFailReason;
        }

        @Comment(value = "经纪人申请-申请时间戳")
        @Required(value = true)
        private Long brokerRequestTime;

        public Long getBrokerRequestTime() {
            return brokerRequestTime;
        }

        public void setBrokerRequestTime(Long brokerRequestTime) {
            this.brokerRequestTime = brokerRequestTime;
        }

        @Comment(value = "经纪人申请-审核通过时间戳")
        @Required(value = true)
        private Long brokerRequestAuditSuccessTime;

        public Long getBrokerRequestAuditSuccessTime() {
            return brokerRequestAuditSuccessTime;
        }

        public void setBrokerRequestAuditSuccessTime(Long brokerRequestAuditSuccessTime) {
            this.brokerRequestAuditSuccessTime = brokerRequestAuditSuccessTime;
        }
    }
}
