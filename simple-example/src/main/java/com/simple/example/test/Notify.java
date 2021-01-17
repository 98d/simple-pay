package com.simple.example.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jin.Z.J  2021/1/15
 */
public class Notify {

    private Map<String,Listener> listenerMap = new HashMap<>();

    public boolean payNotify(String orderNo,String param){
        Listener listener = listenerMap.get(orderNo);
        if(listener == null){
            return false;
        }
        return listener.callback(new Event(param));
    }


    public boolean refundNotfiy(String orderNo,String param){
        Listener listener = listenerMap.get(orderNo);
        if(listener == null){
            return false;
        }
        return listener.callback(new Event(param));
    }


    public void registerListener(String name,Listener listener){
        listenerMap.put(name,listener);
    }


}
