package com.simple.core;

import com.simple.consts.TerminalConst;
import com.simple.enums.PayMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
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
    public SimplePay woa() {
        return this.terminal(TerminalConst.WOA);
    }

    @Override
    public SimplePay getSimplePay(PayMethod method, String terminal){
        SimplePayFactory simplePayFactory = simplePayMethodFactory.getFactory(method);
        if(simplePayFactory == null){
            return null;
        }
        return simplePayFactory.getSimplePay(terminal);
    }

    @Override
    public SimplePay getWeChatPay(String terminal){
        return getSimplePay(PayMethod.WECHAT,terminal);
    }

    @Override
    public SimplePay getAliPay(String terminal){
        return getSimplePay(PayMethod.ALI,terminal);
    }



}
