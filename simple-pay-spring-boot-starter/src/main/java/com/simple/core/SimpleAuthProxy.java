package com.simple.core;

import com.simple.enums.PayMethod;
import com.simple.exception.SimplePayException;
import com.simple.param.SimplePayParam;

/**
 * Created by Jin.Z.J  2021/2/8
 */
public class SimpleAuthProxy implements SimpleAuth {

    private String terminal;

    private SimplePayMethodFactory methodFactory;

    public SimpleAuthProxy(String terminal, SimplePayMethodFactory methodFactory) {
        this.terminal = terminal;
        this.methodFactory = methodFactory;
    }

    @Override
    public <R> R accessToken(SimplePayParam<R> param) throws SimplePayException {
        return getSimpleAuth(param.method()).accessToken(param);
    }

    private SimpleAuth getSimpleAuth(PayMethod method) throws SimplePayException{
        SimplePayFactory simplePayFactory = methodFactory.getFactory(method);
        SimpleAuth simpleAuth = simplePayFactory.getSimpleAuth(method,this.terminal);
        if(simpleAuth == null){
            throw new SimplePayException("Non-existent terminal %s",this.terminal);
        }
        return simpleAuth;
    }
}