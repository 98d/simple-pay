package com.simple.callable;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jin.Z.J  2020/11/26
 */
public abstract class AbstractSimplePayCallable implements SimplePayCallable, InitializingBean {

    @Autowired
    private SimplePayCallableManager callbackManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        callbackManager.register(busCode(),this);
    }

    public abstract String busCode();


}
