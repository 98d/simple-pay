package com.simple.example.test;

/**
 * Created by Jin.Z.J  2021/1/15
 */
public class PayCallbackListener implements Listener{

    @Override
    public boolean callback(Event event) {
        System.out.println("支付回调接收到数据开始处理 ：" + event.getParam()) ;
        return true;
    }
}
