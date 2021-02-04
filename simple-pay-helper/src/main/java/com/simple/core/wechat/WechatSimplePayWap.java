package com.simple.core.wechat;

import cn.hutool.core.util.ReflectUtil;
import com.simple.param.SimplePayParam;
import com.simple.result.wechatpay.WechatUnifiedOrderResult;
import com.simple.exception.SimplePayException;
import com.simple.utils.StringUtils;

import java.net.URLEncoder;

/**
 * 微信移动端(h5)支付
 * Created by Jin.Z.J  2020/11/25
 */
public class WechatSimplePayWap extends WechatSimplePay {

    private WechatSimplePayConfig config;

    private static final String TRADE_TYPE = "MWEB";

    public WechatSimplePayWap(WechatSimplePayConfig config) {
        this.config = config;
    }

    @Override
    public <R> R unifiedOrder(SimplePayParam<R> param) throws SimplePayException {
        String redirect_url = (String) ReflectUtil.getFieldValue(param,"redirect_url");
        WechatUnifiedOrderResult result = super.submitUnifiedOrder(param,(paramMap) -> {
            paramMap.put("appid",this.appId());
            paramMap.put("mch_id",config.getMchid());
            paramMap.put("trade_type",TRADE_TYPE);
            paramMap.remove("openid");
        });
        if(result.isSuccess()){
            if(StringUtils.isNotEmpty(result.getMweb_url())){
                if(StringUtils.isNotEmpty(redirect_url)){
                    try{
                        result.setMweb_url(result.getMweb_url() + "&redirect_url="+ URLEncoder.encode(redirect_url,"UTF-8"));
                    }catch (Exception e){
                    }
                }
            }
            result.getMoreRes().put("body",result.getMweb_url());
        }
        return (R)result;
    }

    @Override
    protected String appId() {
        return config.getWppAppId();
    }

    @Override
    protected WechatSimplePayConfig getConfig() {
        return this.config;

    }
}
