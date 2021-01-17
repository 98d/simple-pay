package com.simple.param;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public abstract class AbstractSimplePayParam<R> implements SimplePayParam<R> {


    private Map<String,Object> otherParam;

    public Map<String, Object> getOtherParam() {
        return otherParam;
    }

    public AbstractSimplePayParam addParam(String key, Object val){
        if(this.otherParam == null){
            this.otherParam = new HashMap<>();
        }
        this.otherParam.put(key,val);
        return this;
    }


}
