package com.simple.core.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.simple.consts.TerminalConst;
import com.simple.core.SimplePay;
import com.simple.core.SimplePaySingleFactory;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class AliSimplePayFactory extends SimplePaySingleFactory {

    private static final String ALIPAY_SERVER_URL = "https://openapi.alipay.com/gateway.do";

    private static final String ALIPAY_FORMAT = "json";

    private static final String ALIPAY_SIGN_TYPE = "RSA2";

    private AlipayClient alipayClient;

    private String appId;

    private String notifyUrl;

    public AliSimplePayFactory(AliSimplePayConfig config) {
        this.appId = config.getAppId();
        this.alipayClient = new DefaultAlipayClient(ALIPAY_SERVER_URL
                , appId
                , config.getPrivateKey()
                , ALIPAY_FORMAT
                , "UTF-8"
                ,config.getAliPayPublicKey()
                , ALIPAY_SIGN_TYPE);
        this.notifyUrl = config.getNotifyUrl();
    }


    @Override
    protected String getKey(String terminal) {
        return this.appId + "-" + terminal;
    }

    @Override
    protected SimplePay createSimplePay(String terminal) {
        if(terminal.equalsIgnoreCase(TerminalConst.APP)){
            return new AliSimplePayApp(this.alipayClient,this.notifyUrl);
        }else if(terminal.equalsIgnoreCase(TerminalConst.H5)){
            return new AliSimplePayWap(alipayClient,this.notifyUrl);
        }else if(terminal.equalsIgnoreCase(TerminalConst.PC)){
            return new AliSimplePayPc(this.alipayClient,this.notifyUrl);
        }else{
            return null;
        }
    }




}
