package com.simple.callable;

import com.simple.exception.SimplePayException;

/**
 * Created by Jin.Z.J  2020/11/26
 */
public interface SimplePayCallable{


    CallableResult payCall(CallableParam callableParam) throws SimplePayException;


    CallableResult refundCall(CallableParam callableParam) throws SimplePayException;


    CallableResult queryTrade(CallableParam callableParam) throws SimplePayException;

}
