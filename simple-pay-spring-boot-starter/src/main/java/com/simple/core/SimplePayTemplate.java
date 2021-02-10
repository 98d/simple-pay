package com.simple.core;

import com.simple.consts.TerminalConst;
import com.simple.enums.PayMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付模板
 * Created by Jin.Z.J  2020/11/26
 */
@Component
public class SimplePayTemplate implements SimplePayOps{

    @Autowired
    private SimplePayMethodFactory simplePayMethodFactory;

    @Override
    public SimplePay terminal(String terminal) {
        return new SimplePayProxy(terminal,simplePayMethodFactory);
    }

    @Override
    public SimplePay h5() {
        return this.terminal(TerminalConst.H5);
    }

    @Override
    public SimplePay app() {
        return this.terminal(TerminalConst.APP);
    }

    @Override
    public SimplePay pc() {
        return this.terminal(TerminalConst.PC);
    }

    @Override
    public SimplePay wpp() {
        return this.terminal(TerminalConst.WPP);
    }

    @Override
    public SimplePay applets() {
        return this.terminal(TerminalConst.APPLETS);
    }

    @Override
    public SimplePay wechatPay(String terminal){
        return getSimplePay(PayMethod.WECHAT,terminal);
    }

    @Override
    public SimplePay aliPay(String terminal){
        return getSimplePay(PayMethod.ALI,terminal);
    }

    @Override
    public SimpleAuth auth(String terminal) {
        return new SimpleAuthProxy(terminal,simplePayMethodFactory);
    }

    @Override
    public SimpleAuth appletsAuth() {
        return auth(TerminalConst.APPLETS);
    }

    @Override
    public SimplePay getSimplePay(PayMethod method, String terminal){
        SimplePayFactory simplePayFactory = getFactory(method);
        if(simplePayFactory == null){
            return null;
        }
        return simplePayFactory.getSimplePay(terminal);
    }

    /**
     * 获取授权
     * @param method
     * @param terminal
     * @return
     */
    public SimpleAuth getSimpleAuth(PayMethod method,String terminal){
        SimplePayFactory simplePayFactory = getFactory(method);
        if(simplePayFactory == null){
            return null;
        }
        return simplePayFactory.getSimpleAuth(method,terminal);
    }

    /**
     * 获取授权
     * @param method
     * @return
     */
    private SimplePayFactory getFactory(PayMethod method){
        return simplePayMethodFactory.getFactory(method);
    }

}
