//package com.jzj.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.jzj.consts.TerminalConst;
//import com.jzj.core.SimplePayTemplate;
//import com.jzj.core.SimplePays;
//import com.jzj.core.callable.CallData;
//import com.jzj.core.callable.CallParam;
//import com.jzj.core.callable.SimplePayCallableManager;
//import com.jzj.core.param.WeChatUnifiedOrderParam;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by Jin.Z.J  2020/11/27
// */
//@RestController
//@RequestMapping("notify")
//public class NotifyController {
//
//    private static final Logger logger = LoggerFactory.getLogger(NotifyController.class);
//
//    private static final String APLIPAY_PUBLIC_KEY = "";
//
//    @Autowired
//    private SimplePayCallableManager simplePayCallableManager;
//    @Autowired
//    private SimplePayTemplate simplePayTemplate;
//
//
//    /**
//     * 支付宝支付回调和退款回调
//     * @param request
//     * @return
//     */
//    @PostMapping("/alipay")
//    public String alipayNotify(HttpServletRequest request){
//        Map<String,String> params = getParamMap(request);
//        logger.info("AliPay notify data:{}", JSONObject.toJSONString(params));
//        try {
//            boolean flag = AlipaySignature.rsaCheckV1(params,APLIPAY_PUBLIC_KEY,"UTF-8", "RSA2");
//            if(!flag){
//                return "sign error";
//            }
//
//
//            WeChatUnifiedOrderParam unifiedOrderParam = SimplePays.WeChat.createUnifiedOrderParam();
//
//            simplePayTemplate.terminal(TerminalConst.H5).unifiedOrder(unifiedOrderParam);
//
//            String out_trade_no = params.get("out_trade_no");
//            CallParam callParam = new CallParam(out_trade_no);
//            callParam.setData(params);
//            callParam.setReqParam(JSON.toJSONString(params));
//            CallData callData;
//            if(params.containsKey("refund_fee") && params.containsKey("gmt_refund")){
//                callData = simplePayCallableManager.refundCallback(callParam);
//            }else{
//                callData = simplePayCallableManager.payCallback(callParam);
//            }
//            if(callData.isSuccess()){
//                return "failure";
//            }
//        } catch (Exception e) {
//            return "exception";
//        }
//        return "success";
//    }
//
//
////
////    /**
////     * 微信支付回调
////     * @param notifyParam
////     * @return
////     */
////    @PostMapping(value = "/wechatpay",produces = "application/xml")
////    public WeChatPayNotifyResult wechatPay(@RequestBody WeChatPayNotifyParam notifyParam){
////        logger.info("WeChatPay notify data:{}", JSONObject.toJSONString(notifyParam));
////        Map<String,Object> paramMap = BeanUtils.beanToMap(notifyParam);
////        String paramSign = (String)paramMap.remove("sign");
////        String sign = WeChatUtils.generateSignData(paramMap);
////        WeChatPayNotifyResult result = new WeChatPayNotifyResult();
////        if(!sign.equals(paramSign)){
////            result.setReturn_code("FAIL");
////            result.setReturn_msg("sign error");
////        }else{
////            try{
////                simplePayCallbackManager.execute(0,notifyParam.getOut_trade_no(),notifyParam);
////            }catch (SimplePayException e){
////                logger.error("WeChatPay notify exception orderNo:{}",notifyParam.getOut_trade_no());
////            }
////            result.setReturn_code("SUCCESS");
////            result.setReturn_msg("OK");
////        }
////        return result;
////    }
////
////
////    /**
////     * 微信退款回调
////     * @param refundNotifyParam
////     * @return
////     */
////    @PostMapping(value = "/wechatpay/refund",produces = "application/xml")
////    public WeChatPayNotifyResult wechatRefund(@RequestBody WeChatRefundNotifyParam refundNotifyParam){
////        logger.info("WeChatPay notify data:{}", JSONObject.toJSONString(refundNotifyParam));
////        WeChatPayNotifyResult result = new WeChatPayNotifyResult();
////        String orderNo = null;
////        try{
////            byte[] b = Base64.decodeBase64(refundNotifyParam.getReq_info());
////            String key = DigestUtils.md5Hex(WeChatUtils.SIGN_KEY).toLowerCase();
////            AES aes = new AES("ECB","PKCS7Padding",key.getBytes());
////            String decryptXml = new String(aes.decrypt(b));
////            Map<String,Object> paramMap = XmlUtil.xmlToMap(decryptXml);
////            orderNo = (String)paramMap.get("out_trade_no");
////            simplePayCallbackManager.execute(1,orderNo,paramMap);
////            result.setReturn_code("SUCCESS");
////            result.setReturn_msg("OK");
////        }catch (Exception e){
////            result.setReturn_code("FAIL");
////            result.setReturn_msg("FAIL");
////            logger.error("WeChatPay notify exception orderNo:{}",orderNo);
////        }
////        return result;
////    }
////
////
////
////
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
//
//
//
//}
