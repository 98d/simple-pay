package com.simple.config;

import com.simple.core.wechat.WechatSimplePayConfig;
import com.simple.utils.BeanUtils;
import com.simple.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Jin.Z.J  2021/2/9
 */
@Configuration
public class SimplePayDbConfig {

    private static final String WECHAT_CONFIG_SQL = "SELECT * FROM wechat_pay_config WHERE state = 1 AND is_del = 0 ORDER BY modify_time DESC LIMIT 1";

    private static final String WECHAT_CONFIG_SQL_BY_ID = "SELECT * FROM wechat_pay_config WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public WechatSimplePayConfig getWechatConfig(){
        WechatSimplePayConfig config = jdbcTemplate.queryForObject(WECHAT_CONFIG_SQL,new BeanPropertyRowMapper<>(WechatSimplePayConfig.class));
        config.setNotifyUrl(format(config.getNotifyUrl(),config));
        return config;
    }

    public WechatSimplePayConfig getWechatConfig(Long id){
        WechatSimplePayConfig config = jdbcTemplate.queryForObject(WECHAT_CONFIG_SQL_BY_ID,new BeanPropertyRowMapper<>(WechatSimplePayConfig.class),id);
        config.setNotifyUrl(format(config.getNotifyUrl(),config));
        return config;
    }

    /**
     * 格式化占位配置
     * @param tempNotifyUrl
     * @param obj
     * @return
     */
    private String format(String tempNotifyUrl,Object obj){
        if(StringUtils.isNotEmpty(tempNotifyUrl) && Pattern.matches(".*\\{([^}]*)\\}.*", tempNotifyUrl)){
            Map<String,Object> map = BeanUtils.beanToMap(obj);
            String arr[] = tempNotifyUrl.split("/");
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];
                if(s.startsWith("{") && s.endsWith("}")){
                    String attr = s.substring(1, s.length() - 1);
                    Object v = map.get(attr);
                    arr[i] = v == null ? "null" : v.toString();
                }
            }
            return Arrays.stream(arr).collect(Collectors.joining("/"));
        }
        return tempNotifyUrl;
    }


}
