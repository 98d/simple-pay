package com.simple.example.test;

/**
 * Created by Jin.Z.J  2021/1/15
 */
public class RefundCallbackListener implements Listener {

    @Override
    public boolean callback(Event event) {
        System.out.println("退款回调接收到数据开始处理 ：" + event.getParam()) ;
        return false;
    }
}
