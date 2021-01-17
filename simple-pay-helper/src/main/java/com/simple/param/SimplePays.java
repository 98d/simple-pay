package com.simple.param;

import com.simple.param.alipay.AliPayCloseOrderParam;
import com.simple.param.alipay.AliPayQueryOrderParam;
import com.simple.param.alipay.AliPayRefundParam;
import com.simple.param.alipay.AliPayUnifiedOrderParam;
import com.simple.param.wechatpay.WechatPayCloseOrderParam;
import com.simple.param.wechatpay.WechatPayQueryOrderParam;
import com.simple.param.wechatpay.WechatPayRefundParam;
import com.simple.param.wechatpay.WechatPayUnifiedOrderParam;

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
