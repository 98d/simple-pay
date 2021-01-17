package com.simple.example.impl;

import com.simple.core.SimplePay;
import com.simple.core.SimplePayTemplate;
import com.simple.example.ITestService;
import com.simple.exception.SimplePayException;
import com.simple.param.SimplePays;
import com.simple.param.alipay.AliPayCloseOrderParam;
import com.simple.param.alipay.AliPayUnifiedOrderParam;
import com.simple.param.wechatpay.WechatPayCloseOrderParam;
import com.simple.param.wechatpay.WechatPayUnifiedOrderParam;
import com.simple.result.wechatpay.WeChatUnifiedOrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl  implements ITestService {

    @Autowired
    private SimplePayTemplate simplePayTemplate;


    public void test(){

        WechatPayUnifiedOrderParam unifiedOrderParam = SimplePays.WeChat.createUnifiedOrderParam();

        try {
            WeChatUnifiedOrderResult unifiedOrderResult = simplePayTemplate.app().unifiedOrder(unifiedOrderParam);

        } catch (SimplePayException e) {
            e.printStackTrace();
        }

    }


}
