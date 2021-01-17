//package com.jzj.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.jzj.core.alipay.SimpleAliPayConfig;
//import com.jzj.core.callable.CallData;
//import com.jzj.core.callable.CallParam;
//import com.jzj.core.callable.SimplePayCallableManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by Jin.Z.J  2021/1/15
// */
//public abstract class CallableController {
//
//    private static final Logger logger = LoggerFactory.getLogger(CallableController.class);
//    @Autowired
//    protected SimplePayCallableManager callableManager;
//    @Autowired
//    private SimpleAliPayConfig aliPayConfig;
//
//    protected String alipay(HttpServletRequest request){
//        Map<String,String> params = getParamMap(request);
//        logger.info("AliPay notify data:{}", JSON.toJSONString(params));
//        try {
//            boolean flag = AlipaySignature.rsaCheckV1(params,aliPayConfig.getAliPayPublicKey(),"UTF-8", "RSA2");
//            if(!flag){
//                return "sign error";
//            }
//            String out_trade_no = params.get("out_trade_no");
//            CallParam callParam = new CallParam(out_trade_no);
//            callParam.setData(params);
//            callParam.setReqParam(JSON.toJSONString(params));
//            CallData callData;
//            if(params.containsKey("refund_fee") && params.containsKey("gmt_refund")){
//                callData = callableManager.refundCallback(callParam);
//            }else{
//                callData = callableManager.payCallback(callParam);
//            }
//            if(callData.isSuccess()){
//                return "failure";
//            }
//        } catch (Exception e) {
//            return "exception";
//        }
//        return "success";
//
//    }
//
//
//
//    private Map<String,String> getParamMap(HttpServletRequest request){
//        Map<String, String> params = new HashMap<>();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用。
//            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//        return params;
//    }
//
//
//}
