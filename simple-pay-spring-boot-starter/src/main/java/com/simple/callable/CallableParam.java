package com.simple.callable;

/**
 * 回调业务参数
 * Created by Jin.Z.J  2020/11/26
 */
public class CallableParam{
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 其他业务数据
     */
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
