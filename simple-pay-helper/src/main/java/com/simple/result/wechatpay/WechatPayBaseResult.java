package com.simple.result.wechatpay;

import java.util.Map;

/**
 * Created by Jin.Z.J  2020/11/25
 */
public class WechatPayBaseResult {

    public static final String SUCCESSFUL = "SUCCESS";

    private Map<String,Object> moreRes;
    private String apiXmlRes;

    public Map<String, Object> getMoreRes() {
        return moreRes;
    }

    public void setMoreRes(Map<String, Object> moreRes) {
        this.moreRes = moreRes;
    }

    public String getApiXmlRes() {
        return apiXmlRes;
    }

    public void setApiXmlRes(String apiXmlRes) {
        this.apiXmlRes = apiXmlRes;
    }
}
