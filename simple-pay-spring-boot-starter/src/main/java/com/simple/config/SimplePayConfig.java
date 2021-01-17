package com.simple.config;

import com.simple.core.SimplePayMethodFactory;
import com.simple.core.alipay.AliSimplePayConfig;
import com.simple.core.wechat.WechatSimplePayConfig;
import com.simple.utils.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by Jin.Z.J  2020/11/26
 */
@ConfigurationProperties(prefix = "simple-pay")
public class SimplePayConfig {

    //统一支付回调通知地址
    private String notifyUrl;
    //统一退款回调地址
    private String refundNotifyUrl;

    private String redirectUrl;

    private final WeChatPayConfig wechatPay = new WeChatPayConfig();

    private final AliPayConfig alipay = new AliPayConfig();


    public static class WeChatPayConfig extends WechatSimplePayConfig {
    }

    public static class AliPayConfig extends AliSimplePayConfig {
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

    public WeChatPayConfig getWechatPay() {
        return wechatPay;
    }

    public AliPayConfig getAlipay() {
        return alipay;
    }


    @Bean
    public SimplePayMethodFactory getSimplePayFactory(){
        if(StringUtils.isNotEmpty(notifyUrl)){
            if(StringUtils.isEmpty(wechatPay.getNotifyUrl())){
                wechatPay.setNotifyUrl(notifyUrl);
            }
            if(StringUtils.isEmpty(alipay.getNotifyUrl())){
                alipay.setNotifyUrl(notifyUrl);
            }
        }
        if(StringUtils.isNotEmpty(redirectUrl)){
            if(StringUtils.isEmpty(wechatPay.getRedirectUrl())){
                wechatPay.setRedirectUrl(redirectUrl);
            }
            if(StringUtils.isEmpty(alipay.getRedirectUrl())){
                alipay.setRedirectUrl(redirectUrl);
            }
        }
        if(StringUtils.isNotEmpty(refundNotifyUrl)){
            if(StringUtils.isEmpty(wechatPay.getRefundNotifyUrl())){
                wechatPay.setRefundNotifyUrl(refundNotifyUrl);
            }
            if(StringUtils.isEmpty(alipay.getRefundNotifyUrl())){
                alipay.setRefundNotifyUrl(refundNotifyUrl);
            }
        }
        return new SimplePayMethodFactory.Builder().wechatPayConfig(wechatPay).aliPayConfig(alipay).build();
    }





}
