package com.simple.example.test;

/**
 * Created by Jin.Z.J  2021/1/15
 */
public class DemoMain {

    public static void main(String[] args) {


        Notify notify = new Notify();

        notify.registerListener("a",new RefundCallbackListener());
        notify.registerListener("b",new PayCallbackListener());

        notify.payNotify("a", "这是支付会到参数");

        notify.refundNotfiy("b","这是退款回调参数");




    }


}
