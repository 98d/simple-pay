package com.simple.core;

import com.simple.param.SimplePayParam;
import com.simple.utils.BeanUtils;

import java.util.Map;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public abstract class AbstractSimplePay implements SimplePay{


    /**
     * 解析参数到Map
     * @param param
     * @return
     */
    protected Map<String,Object> getBizContent(SimplePayParam<?> param){
        Map<String, Object> map = BeanUtils.beanToMap(param);
        Map<String,Object> params = (Map<String,Object>)map.remove("otherParam");
        if(params != null && !params.isEmpty()){
            map.putAll(params);
        }
        return map;
    }



}

