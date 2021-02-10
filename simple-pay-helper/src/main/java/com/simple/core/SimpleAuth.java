package com.simple.core;

import com.simple.exception.SimplePayException;
import com.simple.param.SimplePayParam;

/**
 * Created by Jin.Z.J  2021/2/8
 */
public interface SimpleAuth {

    /**
     * 授权访问令牌
     * @param param
     * @param <R>
     * @return
     * @throws SimplePayException
     */
    <R> R accessToken(SimplePayParam<R> param) throws SimplePayException;

}
