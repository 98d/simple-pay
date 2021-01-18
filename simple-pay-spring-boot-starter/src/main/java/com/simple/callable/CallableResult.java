package com.simple.callable;

/**
 * Created by Jin.Z.J  2020/11/26
 */
public class CallableResult {

    private boolean success;
    private Object data;

    public CallableResult(boolean success) {
        this.success = success;
    }

    public CallableResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
