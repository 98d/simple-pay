# simple-pay
项目介绍
simple-pay(简单支付)集成了支付宝和微信支付(部分),在实际开发中没有可用整合sdk。因支付项目多，便整合了一下,无缝集成了SpringBoot。<br/>
目前仅实现 <br/>
    微信实现终端：app、h5、jsapi 支持：下单、查询(交易查询)、关闭、退款<br/>
    支付宝实现终端:app、h5 支持：下单、查询(交易查询,退款查询)、关闭、退款<br/>
QQ交流群：319444155<br/>
Spring-Boot版本:2.2.1<br/>
建议开发者使用以下环境，可以避免版本带来的问题<br/>
    JDK: JDK1.8+<br/>
    Maven: 3.6.1<br/>

配置文件:
simple-pay:
  alipay:
    app-id: appid
    private-key: 私钥
    ali-pay-public-key: 支付宝公钥
    notify-url: 统一支付回调地址
  wechat-pay:
    sign-key: 签名加密key
    wpp-app-id: 公众平台 appid
    mchid: 商户号
    woa-app-id: 开放平台 appid
    pk12-path: 退款p12证书，默认取classpath路径,例如 refund.p12(有效性待验证)
    notify-url: 统一支付回调地址

支付模板:<br/>
    SimplePayTemplate<br/>
    
下单样例:<br/>
    @Autowired<br/>
    SimplePayTemplate simplePayTemplate;
    
    WechatPayUnifiedOrderParam unifiedOrderParam = SimplePays.WeChat.createUnifiedOrderParam();
    unifiedOrderParam.setNonce_str(IdUtil.simpleUUID());
    unifiedOrderParam.setBody("测试支付");
    unifiedOrderParam.setTotal_fee(10);
    unifiedOrderParam.setSpbill_create_ip(userIp);
    unifiedOrderParam.setOrder_id(orderId);
    unifiedOrderParam.setOpenid(openId);//woa 支付使用。
    unifiedOrderParam.setOut_trade_no(orderNo);
    unifiedOrderParam.setRedirect_url(redirectUrl);//h5重定向链接
    try{
       WechatUnifiedOrderResult unifiedOrderResult = simplePayTemplate.h5().unifiedOrder(unifiedOrderParam);
       if(!unifiedOrderResult.isSuccess()){
           //失败
       }else{
            //成功
       }
    }catch (SimplePayException e){
       //异常
    }
    
开源说明
本系统100%开源，遵守Apache2.0协议
