package com.simple.core.alipay;

import com.alipay.api.AlipayClient;
import com.simple.exception.SimplePayException;
import com.simple.param.SimplePayParam;

/**
 * Created by Jin.Z.J  2021/2/8
 */
public class AliSimplePayApplets extends AliSimplePay {

    public AliSimplePayApplets(AlipayClient alipayClient, AliSimplePayConfig config) {
        super(alipayClient, config);
    }



    @Override
    public <R> R unifiedOrder(SimplePayParam<R> param) throws SimplePayException {

        return null;
    }
}
