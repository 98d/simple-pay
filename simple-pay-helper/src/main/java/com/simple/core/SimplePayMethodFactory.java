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
import java.util.function.Supplier;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class SimplePayMethodFactory extends AbstractSimplePayFactory{


    private final boolean wechatSingleCase;

    private final boolean aliSingleCase;

    private Supplier<WechatSimplePayConfig> wechatSupplier;

    private Supplier<AliSimplePayConfig> aliSupplier;

    private Map<PayMethod,SimplePayFactory> simplePayFactoryCache = new ConcurrentHashMap<>(2);


    public SimplePayMethodFactory(Supplier<WechatSimplePayConfig> wechatSupplier, Supplier<AliSimplePayConfig> aliSupplier) {
        this(true,true,wechatSupplier,aliSupplier);
    }

    public SimplePayMethodFactory(boolean wechatSingleCase,boolean aliSingleCase, Supplier<WechatSimplePayConfig> wechatSupplier, Supplier<AliSimplePayConfig> aliSupplier) {
        this.wechatSingleCase = wechatSingleCase;
        this.aliSingleCase = aliSingleCase;
        this.wechatSupplier = wechatSupplier;
        this.aliSupplier = aliSupplier;
    }

    @Override
    public SimplePayFactory getFactory(PayMethod method) {
        Objects.requireNonNull(method,"pay method can not be null");
        if(method.equals(PayMethod.WECHAT)){
            if(wechatSingleCase){
                return Optional.ofNullable(simplePayFactoryCache.get(method)).orElseGet(() -> {
                    SimplePayFactory simplePayFactory = getWechatSimplePayFactory();
                    this.simplePayFactoryCache.put(method,simplePayFactory);
                    return simplePayFactory;
                });
            }else{
                return getWechatSimplePayFactory();
            }
        }else{
            if(aliSingleCase){
                return Optional.ofNullable(simplePayFactoryCache.get(method)).orElseGet(() -> {
                    SimplePayFactory simplePayFactory = getAliSimplePayFactory();
                    this.simplePayFactoryCache.put(method,simplePayFactory);
                    return simplePayFactory;
                });
            }else{
                return getAliSimplePayFactory();
            }
        }
    }


    private SimplePayFactory getWechatSimplePayFactory(){
        WechatSimplePayConfig wechatSimplePayConfig = wechatSupplier.get();
        if(wechatSimplePayConfig == null){
            throw new RuntimeException("wechat payment is not configured");
        }
        return new WechatSimplePayFactory(wechatSimplePayConfig);
    }


    private SimplePayFactory getAliSimplePayFactory(){
        AliSimplePayConfig aliPayConfig = aliSupplier.get();
        if(aliPayConfig == null){
            throw new RuntimeException("ali payment is not configured");
        }
        return new AliSimplePayFactory(aliPayConfig);
    }



}
