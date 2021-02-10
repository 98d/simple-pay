package com.simple.core;

import com.simple.enums.PayMethod;
/**
 * Created by Jin.Z.J  2020/11/25
 */
public interface SimplePayFactory {


    SimplePay getSimplePay(String terminal);


    SimpleAuth getSimpleAuth(PayMethod method, String terminal);
}
