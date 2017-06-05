package com.github.xuzw.forexroo.app.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "已绑定的银行卡 - 查询详情")
@GenerateByApiEngineSdk(time = "2017.06.05 11:14:45.822", version = "v0.0.19")
public class BindedBankCard_QueryDetail_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
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
