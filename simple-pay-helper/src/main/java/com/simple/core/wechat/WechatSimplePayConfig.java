package com.simple.core.wechat;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class WechatSimplePayConfig {

    //统一支付回调通知地址
    private String notifyUrl;
    //公众号 appid
    private String woaAppId;
    //公众平台 appid
    private String wppAppId;
    //签名signKey
    private String signKey;
    //商户号
    private String mchid;
    //pk12证书路径
    private String pk12Path;
    //统一退款回调地址
    private String refundNotifyUrl;

    private String redirectUrl;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getWoaAppId() {
        return woaAppId;
    }

    public void setWoaAppId(String woaAppId) {
        this.woaAppId = woaAppId;
    }

    public String getWppAppId() {
        return wppAppId;
    }

    public void setWppAppId(String wppAppId) {
        this.wppAppId = wppAppId;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getPk12Path() {
        return pk12Path;
    }

    public void setPk12Path(String pk12Path) {
        this.pk12Path = pk12Path;
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
