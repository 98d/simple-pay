//package com.jzj.controller;
//
//import com.jzj.common.APIResult;
//import com.jzj.core.SimplePayTemplate;
//import com.jzj.core.SimplePays;
//import com.jzj.core.param.WeChatUnifiedOrderParam;
//import com.jzj.core.result.WeChatUnifiedOrderResult;
//import com.jzj.exception.SimplePayException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// *
// * Created by Jin.Z.J  2020/11/26
// */
//@RestController
//@RequestMapping("/api/pay")
//public class TestController {
//
//
//    @Autowired
//    private SimplePayTemplate simplePayTemplate;
//
//
//
//    /**
//     * 下单请求
//     * @param type
//     * @param request
//     * @return
//     */
//    @PostMapping("unifiedOrder")
//    public APIResult unifiedOrder(@RequestParam("type") Integer type, HttpServletRequest request){
//
//        WeChatUnifiedOrderParam unifiedOrderParam = SimplePays.WeChat.createUnifiedOrderParam();
//        try{
//            WeChatUnifiedOrderResult unifiedOrderResult = simplePayTemplate.h5().unifiedOrder(unifiedOrderParam);
//            if(unifiedOrderResult.isSuccess()){
//
//            }else{
//
//            }
//        }catch (SimplePayException e){
//
//        }
//
//        return null;
//    }
//
////
////
////
////    @PostMapping("queryOrder")
////    public APIResult queryOrder(@RequestParam("type")Integer type,@RequestParam("orderNo")String orderNo,HttpServletRequest request){
////        String terminal = request.getHeader("terminal");
////        if(StringUtils.isBlank(terminal)){
////            return new APIResult(APIEnum.PARAM_ERROR);
////        }
////        try{
////            return new APIResult(testPayService.queryTradeOrder(type,terminal,orderNo));
////        }catch (SimplePayException e){
////            return new APIResult(e);
////        }
////    }
////
////
////
////    @PostMapping("closeOrder")
////    public APIResult closeOrder(@RequestParam("type")Integer type,@RequestParam("orderNo")String orderNo,HttpServletRequest request){
////        String terminal = request.getHeader("terminal");
////        if(StringUtils.isBlank(terminal)){
////            return new APIResult(APIEnum.PARAM_ERROR);
////        }
////        try{
////            boolean flag = testPayService.closeOrder(type,terminal,orderNo);
////            return new APIResult(flag);
////        }catch (SimplePayException e){
////            return new APIResult(e);
////        }
////    }
//
//
//
//}
