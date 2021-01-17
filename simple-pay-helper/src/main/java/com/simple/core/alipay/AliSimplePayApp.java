package com.simple.core.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.simple.param.SimplePayParam;
import com.simple.result.alipay.AliPayUnifiedOrderResult;
import com.simple.exception.SimplePayException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class AliSimplePayApp extends AliSimplePay {


    private AlipayClient alipayClient;

    private String notifyUrl;

    public AliSimplePayApp(AlipayClient alipayClient) {
        super(alipayClient);
        this.alipayClient = alipayClient;
    }

    public AliSimplePayApp(AlipayClient alipayClient, String notifyUrl) {
        this(alipayClient);
        this.notifyUrl = notifyUrl;
    }

    @Override
    public <R> R unifiedOrder(SimplePayParam<R> param) throws SimplePayException {
        Map<String, Object> map = getBizContent(param);
        //订单主键id
        Long orderId = (Long) map.remove("orderId");
        //订单号
        String orderNo = (String) map.get("out_trade_no");
        String notifyUrl = (String) map.remove("notify_url");
        if(StringUtils.isBlank(notifyUrl)){
            notifyUrl = this.notifyUrl;
        }
        try{
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
            request.setNotifyUrl(notifyUrl);
            request.setBizContent(JSONObject.toJSONString(map));
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            AliPayUnifiedOrderResult result = new AliPayUnifiedOrderResult();
            result.setOrderNo(orderNo);
            result.setResponse(response);
            result.setOrderId(orderId);
            return (R) result;
        }catch (AlipayApiException e){
            throw new SimplePayException(e.getErrCode() + ":" + e.getErrCode());
        }
    }

}
