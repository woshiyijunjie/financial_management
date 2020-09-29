package com.junjie.financial_management.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author yijunjie
 * @date 2020/3/14 - 13:26
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                //开启驼峰命名法则 数据库的下划线法  编程用对应的驼峰命名法来取出来
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

}
