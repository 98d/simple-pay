package com.simple.config;

import com.simple.core.SimplePayBaseConfig;
import com.simple.core.SimplePayMethodFactory;
import com.simple.core.alipay.AliSimplePayConfig;
import com.simple.core.wechat.WechatSimplePayConfig;
import com.simple.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 支付相关配置类
 * Created by Jin.Z.J  2020/11/26
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "simple-pay")
public class SimplePayConfig {

    @Autowired
    private SimplePayDbConfig simplePayDbConfig;

    private static final String CONFIG_TYPE_PROPERTIES = "properties";
    private static final String CONFIG_TYPE_DB = "db";
    //统一支付回调通知地址
    private String notifyUrl;
    //统一退款回调地址
    private String refundNotifyUrl;
    //h5重定向跳转地址
    private String redirectUrl;
    //微信支付相关配置
    private final WechatSimplePayConfig wechatPay = new WechatSimplePayConfig();
    //支付宝相关配置
    private final AliSimplePayConfig alipay = new AliSimplePayConfig();

    private boolean wechatSingleCase;

    private boolean aliSingleCase;

    private String wechatConfigType ;
    private String aliConfigType;

    public SimplePayConfig() {
        this.wechatConfigType = CONFIG_TYPE_PROPERTIES;
        this.aliConfigType = CONFIG_TYPE_PROPERTIES;
        this.wechatSingleCase = true;
        this.aliSingleCase = true;
    }


    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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

    public WechatSimplePayConfig getWechatPay() {
        return wechatPay;
    }

    public AliSimplePayConfig getAlipay() {
        return alipay;
    }

    public String getWechatConfigType() {
        return wechatConfigType;
    }

    public void setWechatConfigType(String wechatConfigType) {
        this.wechatConfigType = wechatConfigType;
    }

    public String getAliConfigType() {
        return aliConfigType;
    }

    public void setAliConfigType(String aliConfigType) {
        this.aliConfigType = aliConfigType;
    }

    public boolean isWechatSingleCase() {
        return wechatSingleCase;
    }

    public void setWechatSingleCase(boolean wechatSingleCase) {
        this.wechatSingleCase = wechatSingleCase;
    }

    public boolean isAliSingleCase() {
        return aliSingleCase;
    }

    public void setAliSingleCase(boolean aliSingleCase) {
        this.aliSingleCase = aliSingleCase;
    }


    @Bean
    public SimplePayMethodFactory getSimplePayFactory(){
        return new SimplePayMethodFactory(wechatSingleCase,aliSingleCase,() -> {
            WechatSimplePayConfig config;
            if(wechatConfigType.equalsIgnoreCase(CONFIG_TYPE_PROPERTIES)){
                config = this.wechatPay;
            }else{
                config = simplePayDbConfig.getWechatConfig();
            }
            setDefaultProp(config);
            return config;
        },() -> {
            AliSimplePayConfig config = this.alipay;
            setDefaultProp(config);
            return config;
        });
    }





    /**
     * 设置默认配置
     * @param config
     */
    private void setDefaultProp(SimplePayBaseConfig config){
        if(StringUtils.isEmpty(config.getNotifyUrl())){
            config.setNotifyUrl(this.notifyUrl);
        }
        if(StringUtils.isEmpty(config.getRefundNotifyUrl())){
            config.setRefundNotifyUrl(this.refundNotifyUrl);
        }
        if(StringUtils.isEmpty(config.getRedirectUrl())){
            config.setRedirectUrl(this.redirectUrl);
        }
    }




}
