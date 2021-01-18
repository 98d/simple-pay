package com.simple.core;

import com.simple.core.alipay.AliSimplePayConfig;
import com.simple.core.alipay.AliSimplePayFactory;
import com.simple.core.wechat.WechatSimplePayConfig;
import com.simple.core.wechat.WechatSimplePayFactory;
import com.simple.enums.PayMethod;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class SimplePayMethodFactory extends AbstractSimplePayFactory{

    private final WechatSimplePayConfig weChatPayConfig;

    private final AliSimplePayConfig aliPayConfig;

    private Map<PayMethod,SimplePayFactory> simplePayFactoryCache = new ConcurrentHashMap<>(2);

    private SimplePayMethodFactory(WechatSimplePayConfig weChatPayConfig, AliSimplePayConfig aliPayConfig) {
        this.weChatPayConfig = weChatPayConfig;
        this.aliPayConfig = aliPayConfig;
    }

    @Override
    public SimplePayFactory getFactory(PayMethod method) {
        Objects.requireNonNull(method,"pay method can not be null");
        return Optional.ofNullable(simplePayFactoryCache.get(method)).orElseGet(() -> {
            SimplePayFactory simplePayFactory;
            if(method.equals(PayMethod.WECHAT)){
                if(weChatPayConfig == null){
                    throw new RuntimeException("wechat payment is not configured");
                }
                simplePayFactory = new WechatSimplePayFactory(weChatPayConfig);
            }else{
                if(aliPayConfig == null){
                    throw new RuntimeException("ali payment is not configured");
                }
                simplePayFactory = new AliSimplePayFactory(aliPayConfig);
            }
            this.simplePayFactoryCache.put(method,simplePayFactory);
            return simplePayFactory;
        });
    }


    public static class Builder{

        private WechatSimplePayConfig wechatPayConfig;
        private AliSimplePayConfig aliPayConfig;

        public Builder wechatPayConfig(WechatSimplePayConfig wechatPayConfig){
            this.wechatPayConfig = wechatPayConfig;
            return this;
        }

        public Builder aliPayConfig(AliSimplePayConfig aliPayConfig){
            this.aliPayConfig = aliPayConfig;
            return this;
        }

        public SimplePayMethodFactory build(){
            return new SimplePayMethodFactory(this.wechatPayConfig,this.aliPayConfig);
        }

    }




}
