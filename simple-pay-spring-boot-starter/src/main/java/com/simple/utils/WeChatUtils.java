package com.simple.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

/**
 * Created by Jin.Z.J  2020/11/26
 */
public class WeChatUtils {


    public static final String SIGN_KEY = "";

    public static <T> String generateSignData(T bean) {
        Map<String,Object> paramMap;
        if(bean instanceof Map){
            paramMap = (Map<String,Object>)bean;
        }else{
            paramMap = BeanUtil.beanToMap(bean);
        }
        String str = MapUtil.sortJoin(paramMap,"&","=",true,null);
        StringBuilder sb = new StringBuilder(str).append("&key=").append(SIGN_KEY);
        String sign = DigestUtils.md5Hex(sb.toString()).toUpperCase();
        return sign;
    }

}
