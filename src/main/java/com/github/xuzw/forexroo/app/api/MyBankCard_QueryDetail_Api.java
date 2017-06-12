package com.github.xuzw.forexroo.app.api;

import static com.github.xuzw.forexroo.entity.Tables.USER;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo.database.Jooq;
import com.github.xuzw.forexroo.database.model.MyBankCardStatusEnum;
import com.github.xuzw.forexroo.entity.Tables;
import com.github.xuzw.forexroo.entity.tables.daos.MyBankCardDao;
import com.github.xuzw.forexroo.entity.tables.daos.UserDao;
import com.github.xuzw.forexroo.entity.tables.pojos.MyBankCard;
import com.github.xuzw.forexroo.entity.tables.pojos.User;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "我的银行卡 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.12 12:45:53.980", version = "v0.0.36")
public class MyBankCard_QueryDetail_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        UserDao userDao = new UserDao(Jooq.buildConfiguration());
        User user = userDao.fetchOne(USER.TOKEN, req.getToken());
        MyBankCardDao myBankCardDao = new MyBankCardDao(Jooq.buildConfiguration());
        MyBankCard myBankCard = myBankCardDao.fetchOne(Tables.MY_BANK_CARD.USER_ID, user.getId());
        Resp resp = new Resp();
        if (myBankCard != null && myBankCard.getStatus() == MyBankCardStatusEnum.binding_success.getValue()) {
            resp.setBankCardNumber(myBankCard.getBankCardNumber());
            resp.setBankImage(myBankCard.getBankImage());
            resp.setBankName(myBankCard.getBankName());
            resp.setCardName(myBankCard.getCardName());
            resp.setCardType(myBankCard.getCardType());
            resp.setServicePhone(myBankCard.getServicePhone());
        }
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

        @Comment(value = "用户唯一标识码")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "银行卡号")
        @Required(value = true)
        private String bankCardNumber;

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
        }

        @Comment(value = "银行LOGO")
        @Required(value = true)
        private String bankImage;

        public String getBankImage() {
            return bankImage;
        }

        public void setBankImage(String bankImage) {
            this.bankImage = bankImage;
        }

        @Comment(value = "银行名称")
        @Required(value = true)
        private String bankName;

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        @Comment(value = "卡名称")
        @Required(value = true)
        private String cardName;

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        @Comment(value = "卡类型")
        @Required(value = true)
        private String cardType;

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        @Comment(value = "服务热线")
        @Required(value = true)
        private String servicePhone;

        public String getServicePhone() {
            return servicePhone;
        }

        public void setServicePhone(String servicePhone) {
            this.servicePhone = servicePhone;
        }
    }
}
