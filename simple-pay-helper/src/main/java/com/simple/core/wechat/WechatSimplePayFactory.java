package com.simple.core.wechat;

import com.simple.consts.TerminalConst;
import com.simple.core.SimplePay;
import com.simple.core.SimplePaySingleFactory;

/**
 * 微信支付工厂
 * Created by Jin.Z.J  2020/11/25
 */
public class WechatSimplePayFactory extends SimplePaySingleFactory {

    private WechatSimplePayConfig config;

    public WechatSimplePayFactory(WechatSimplePayConfig config) {
        this.config = config;
    }

    @Override
    protected String getKey(String terminal) {
        StringBuilder builder = new StringBuilder(terminal);
        if(terminal.equals(TerminalConst.APP)){
            builder.append("-").append(config.getWppAppId()).append("-").append(config.getMchid());
        }else{
            builder.append("-").append(config.getWoaAppId()).append("-").append(config.getMchid());
        }
        return builder.toString();
    }

    //支付宝/app/h5
    //微信 app/h5/公众号jsapi

    @Override
    protected SimplePay createSimplePay(String terminal) {
        if(terminal.equalsIgnoreCase(TerminalConst.APP)){
            return new WechatSimplePayApp(config);
        }else if(terminal.equalsIgnoreCase(TerminalConst.WPP)){
            return new WechatSimplePayWpp(config);
        }else if(terminal.equalsIgnoreCase(TerminalConst.H5)){
            return new WechatSimplePayWap(config);
        }else{
            return null;
        }
    }
}
