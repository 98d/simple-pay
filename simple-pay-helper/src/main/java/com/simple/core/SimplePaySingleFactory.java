package com.simple.core;

import com.simple.enums.PayMethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;


/**
 * 生产单例 SimplePay 工厂
 * Created by Jin.Z.J  2020/11/25
 */
public abstract class SimplePaySingleFactory implements SimplePayFactory{

    /**缓存已经生产过的 SimplePay 对象*/
    private static final SimpleCache<Object> cache = new SimpleCache<>();

    private static class SimpleCache<T>{

        private final Map<String,T> cache = new ConcurrentHashMap<>();

        public T get(String key, Supplier<T> supplier){
            T obj = cache.get(key);
            if(obj == null){
                obj = supplier.get();
                if(obj != null){
                    this.cache.put(key,obj);
                }
            }
            return obj;
        }
    }


    @Override
    public SimplePay getSimplePay(String terminal) {
        String attrKey = this.getKey(terminal);
        return (SimplePay)cache.get(attrKey,() -> this.createSimplePay(terminal));
    }

    @Override
    public SimpleAuth getSimpleAuth(PayMethod method,String terminal) {
        String key = method.getName() + "-" + terminal;
        return (SimpleAuth)cache.get(key,() -> this.createSimpleAuth(terminal));
    }

    /**
     * 唯一key
     * @param terminal
     * @return
     */
    protected abstract String getKey(String terminal);


    /**
     * 创建
     * @param terminal
     * @return
     */
    protected abstract SimplePay createSimplePay(String terminal);

    protected abstract SimpleAuth createSimpleAuth(String terminal);

}
