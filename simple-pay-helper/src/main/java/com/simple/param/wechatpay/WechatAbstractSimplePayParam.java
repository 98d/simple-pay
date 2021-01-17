package com.simple.param.wechatpay;

import com.simple.param.AbstractSimplePayParam;
import com.simple.enums.PayMethod;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public abstract class WechatAbstractSimplePayParam<R> extends AbstractSimplePayParam<R> {

    @Override
    public PayMethod method() {
        return PayMethod.WECHAT;
    }

}
