package com.simple.core.callable;

/**
 * Created by Jin.Z.J  2020/11/26
 */
public class CallableParam{
    //原参数
    private String orderNo;
    private Object data;

    public CallableParam(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
