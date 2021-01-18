package com.simple.param;

import com.simple.enums.PayMethod;


/**
 * Created by Jin.Z.J  2020/11/25
 */
public interface SimplePayParam<R> {


    PayMethod method();


    String requestURI();


    Class<R> resClass();


}
