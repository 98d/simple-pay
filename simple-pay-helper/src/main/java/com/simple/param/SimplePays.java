package com.simple.param;

import cn.hutool.core.map.MapUtil;
import com.simple.param.alipay.AliPayCloseOrderParam;
import com.simple.param.alipay.AliPayQueryOrderParam;
import com.simple.param.alipay.AliPayRefundParam;
import com.simple.param.alipay.AliPayUnifiedOrderParam;
import com.simple.param.wechatpay.WechatPayCloseOrderParam;
import com.simple.param.wechatpay.WechatPayQueryOrderParam;
import com.simple.param.wechatpay.WechatPayRefundParam;
import com.simple.param.wechatpay.WechatPayUnifiedOrderParam;
import com.simple.utils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public abstract class SimplePays {

    private SimplePays(){

    }


    public final static class WeChat{

        public static WechatPayUnifiedOrderParam createUnifiedOrderParam(){
            return new WechatPayUnifiedOrderParam();
        }

        public static WechatPayCloseOrderParam createCloseOrderParam(){
            return new WechatPayCloseOrderParam();
        }

        public static WechatPayQueryOrderParam createQueryOrderParam(){
            return new WechatPayQueryOrderParam();
        }

        public static WechatPayRefundParam createRefundParam(){
            return new WechatPayRefundParam();
        }

        /**
         * @param bean javaBean 和 Map
         * @param signKey 加密秘串
         * @param <T>
         * @return
         */
        public static <T> String getSign(T bean,String signKey) {
            Map<String,Object> paramMap;
            if(bean instanceof Map){
                paramMap = (Map<String,Object>)bean;
            }else{
                paramMap = BeanUtils.beanToMap(bean);
            }
            String str = MapUtil.sortJoin(paramMap,"&","=",true,null);
            StringBuilder sb = new StringBuilder(str).append("&key=").append(signKey);
            String sign = DigestUtils.md5Hex(sb.toString()).toUpperCase();
            return sign;
        }


    }

    public final static class Ali{

        public static AliPayUnifiedOrderParam createUnifiedOrderParam(){
            return new AliPayUnifiedOrderParam();
        }

        public static AliPayCloseOrderParam createCloseOrderParam(){
            return new AliPayCloseOrderParam();
        }

        public static AliPayQueryOrderParam createQueryOrderParam(){
            return new AliPayQueryOrderParam();
        }

        public static AliPayRefundParam createRefundParam(){
            return new AliPayRefundParam();
        }

    }



}
