package com.simple.core.alipay;

import com.simple.core.SimplePayBaseConfig;

/**
 * Created by Jin.Z.J 2020/11/25
 */
public class AliSimplePayConfig extends SimplePayBaseConfig {

    private Long id;

    private String appId;
    private String privateKey;
    private String aliPayPublicKey;

    private String appletsAppId;
    private String appletsPrivateKey;
    private String appletsAliPayPublicKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAliPayPublicKey() {
        return aliPayPublicKey;
    }

    public void setAliPayPublicKey(String aliPayPublicKey) {
        this.aliPayPublicKey = aliPayPublicKey;
    }

    public String getAppletsAppId() {
        return appletsAppId;
    }

    public void setAppletsAppId(String appletsAppId) {
        this.appletsAppId = appletsAppId;
    }

    public String getAppletsPrivateKey() {
        return appletsPrivateKey;
    }

    public void setAppletsPrivateKey(String appletsPrivateKey) {
        this.appletsPrivateKey = appletsPrivateKey;
    }

    public String getAppletsAliPayPublicKey() {
        return appletsAliPayPublicKey;
    }

    public void setAppletsAliPayPublicKey(String appletsAliPayPublicKey) {
        this.appletsAliPayPublicKey = appletsAliPayPublicKey;
    }
}
