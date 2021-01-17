package com.simple.core.callable;

import com.simple.exception.SimplePayException;
import com.simple.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jin.Z.J  2020/11/26
 */
@Component
public class SimplePayCallableManager implements SimplePayCallable{

    private static final Logger logger = LoggerFactory.getLogger(SimplePayCallableManager.class);

    private final Map<String, SimplePayCallable> callbackMap = new ConcurrentHashMap<>();

    public void register(String busCode, SimplePayCallable callback){
        if(callbackMap.containsKey(busCode)){
            throw new IllegalArgumentException(String.format("busCode [%s] already exists",busCode));
        }
        logger.info("{} register success busCode:{}",callback.getClass().getName(),busCode);
        callbackMap.put(busCode,callback);
    }


    /**
     *
     * @param callableParam
     * @return
     * @throws SimplePayException
     */
    @Override
    public CallableResult payCall(CallableParam callableParam) throws SimplePayException {
        return getCallable(callableParam.getOrderNo()).payCall(callableParam);
    }

    /**
     *
     * @param callableParam
     * @return
     * @throws SimplePayException
     */
    @Override
    public CallableResult refundCall(CallableParam callableParam) throws SimplePayException {
        return getCallable(callableParam.getOrderNo()).refundCall(callableParam);
    }


    /**
     *
     * @param callableParam
     * @return
     * @throws SimplePayException
     */
    @Override
    public CallableResult queryTrade(CallableParam callableParam) throws SimplePayException {
        return getCallable(callableParam.getOrderNo()).queryTrade(callableParam);
    }


    /**
     *
     * @param orderNo
     * @return
     */
    private SimplePayCallable getCallable(String orderNo) throws SimplePayException {
        if(StringUtils.isNotEmpty(orderNo)){
            for(Map.Entry<String,SimplePayCallable> entry : callbackMap.entrySet()){
                if(orderNo.startsWith(entry.getKey())){
                    return entry.getValue();
                }
            }
        }
        throw new SimplePayException("not exist callable");
    }


}
