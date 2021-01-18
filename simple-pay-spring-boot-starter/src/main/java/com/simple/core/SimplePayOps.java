package com.simple.core;

import com.simple.enums.PayMethod;

public interface SimplePayOps {


    SimplePay terminal(String terminal);


    SimplePay h5();


    SimplePay app();


    SimplePay pc();


    SimplePay woa();


    SimplePay getSimplePay(PayMethod method, String terminal);


    SimplePay getWechatPay(String terminal);


    SimplePay getAliPay(String terminal);



}
