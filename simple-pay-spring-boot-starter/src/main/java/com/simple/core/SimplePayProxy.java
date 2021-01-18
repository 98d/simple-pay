package com.simple.core;

import com.simple.param.SimplePayParam;
import com.simple.enums.PayMethod;
import com.simple.exception.SimplePayException;

/**
 * 支付代理
 */
public class SimplePayProxy implements SimplePay {

    private String terminal;

    private SimplePayMethodFactory methodFactory;

    public SimplePayProxy(String terminal, SimplePayMethodFactory methodFactory) {
        this.terminal = terminal;
        this.methodFactory = methodFactory;
    }

    @Override
    public <R> R queryTradeOrder(SimplePayParam<R> param) throws SimplePayException {
        return getSimplePay(param.method()).queryTradeOrder(param);
    }

    @Override
    public <R> R closeOrder(SimplePayParam<R> param) throws SimplePayException {
        return getSimplePay(param.method()).closeOrder(param);
    }

    @Override
    public <R> R refund(SimplePayParam<R> param) throws SimplePayException {
        return getSimplePay(param.method()).refund(param);
    }

    @Override
    public <R> R queryRefund(SimplePayParam<R> param) throws SimplePayException {
        return getSimplePay(param.method()).queryRefund(param);
    }

    @Override
    public <R> R unifiedOrder(SimplePayParam<R> param) throws SimplePayException {
        return getSimplePay(param.method()).unifiedOrder(param);
    }


    private SimplePay getSimplePay(PayMethod method) throws SimplePayException{
        SimplePayFactory simplePayFactory = methodFactory.getFactory(method);
        SimplePay simplePay = simplePayFactory.getSimplePay(this.terminal);
        if(simplePay == null){
            throw new SimplePayException("Non-existent terminal %s",this.terminal);
        }
        return simplePay;
    }


}
