package com.simple.core.wechat;

import com.simple.core.SimplePayBaseConfig;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class WechatSimplePayConfig extends SimplePayBaseConfig {

    private Long id;


    //开放平台 appid
    private String woaAppId;
    //开放平台 secret
    private String woaSecret;

    //公众平台 appid
    private String wppAppId;
    //公众平台 secret
    private String wppSecret;
    //签名signKey
    private String signKey;
    //商户号
    private String mchid;
    //pk12证书路径
    private String pk12Path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWoaAppId() {
        return woaAppId;
    }

    public void setWoaAppId(String woaAppId) {
        this.woaAppId = woaAppId;
    }

    public String getWoaSecret() {
        return woaSecret;
    }

    public void setWoaSecret(String woaSecret) {
        this.woaSecret = woaSecret;
    }

    public String getWppAppId() {
        return wppAppId;
    }

    public void setWppAppId(String wppAppId) {
        this.wppAppId = wppAppId;
    }

    public String getWppSecret() {
        return wppSecret;
    }

    public void setWppSecret(String wppSecret) {
        this.wppSecret = wppSecret;
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

}
