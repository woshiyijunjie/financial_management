package com.junjie.financial_management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//关于解决跨域的配置
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                .exposedHeaders("access-control-allow-headers", "access-control-allow-methods", "access-control-allow" +
                        "-origin", "access-control-max-age", "X-Frame-Options","Authorization")
                .allowCredentials(false)
                .maxAge(3600 * 24);
    }
}
