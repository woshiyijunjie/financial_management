package com.junjie.financial_management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//用来解决上传的图片需要重新启动服务的问题
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/images/**").addResourceLocations("file:E:\\software_install_pathaddadd\\IDEAWorkSpace\\financial_management\\src\\main\\resources\\static\\images\\"); /*绝对路径*/
        }
        super.addResourceHandlers(registry);
    }

}