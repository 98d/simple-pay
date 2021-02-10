package com.simple.core.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.simple.consts.TerminalConst;
import com.simple.core.SimpleAuth;
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

    private AlipayClient appletsClient;

    private AliSimplePayConfig config;


    public AliSimplePayFactory(AliSimplePayConfig config) {

        this.alipayClient = new DefaultAlipayClient(ALIPAY_SERVER_URL
                , config.getAppId()
                , config.getPrivateKey()
                , ALIPAY_FORMAT
                , "UTF-8"
                ,config.getAliPayPublicKey()
                , ALIPAY_SIGN_TYPE);

        this.appletsClient = new DefaultAlipayClient(ALIPAY_SERVER_URL
                , config.getAppletsAppId()
                , config.getAppletsPrivateKey()
                , ALIPAY_FORMAT
                , "UTF-8"
                ,config.getAppletsAliPayPublicKey()
                , ALIPAY_SIGN_TYPE);

        this.config = config;

    }


    @Override
    protected String getKey(String terminal) {
        if(terminal.equalsIgnoreCase(TerminalConst.APPLETS)){
            return terminal + "-" + this.config.getAppletsAppId();
        }
        return terminal + "-" + this.config.getAppId();
    }

    @Override
    protected SimplePay createSimplePay(String terminal) {
        if(terminal.equalsIgnoreCase(TerminalConst.APP)){
            return new AliSimplePayApp(this.alipayClient,this.config);
        }else if(terminal.equalsIgnoreCase(TerminalConst.H5)){
            return new AliSimplePayWap(alipayClient,this.config);
        }else if(terminal.equalsIgnoreCase(TerminalConst.PC)){
            return new AliSimplePayPc(this.alipayClient,this.config);
        }else if(terminal.equalsIgnoreCase(TerminalConst.APPLETS)){
            return new AliSimplePayApplets(appletsClient,this.config);
        }else{
            return null;
        }
    }


    @Override
    protected SimpleAuth createSimpleAuth(String terminal) {
        if(TerminalConst.APPLETS.equalsIgnoreCase(terminal)){
            return new AliSimpleAuth(appletsClient);
        }else{
            return new AliSimpleAuth(alipayClient);
        }
    }
}
