package com.simple.config;

import com.simple.core.SimplePay;
import com.simple.core.SimplePayTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jin.Z.J  2021/2/5
 */
@Configuration
@ConditionalOnClass({SimplePay.class})
@EnableConfigurationProperties({SimplePayConfig.class})
public class SimplePayAutoConfigure {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimplePayAutoConfigure.class);

    public SimplePayAutoConfigure() {
    }

    @Bean
    @ConditionalOnMissingBean
    public SimplePayTemplate simplePayTemplate() {
        LOGGER.info("Init SimplePayTemplate");
        return new SimplePayTemplate();
    }


}
