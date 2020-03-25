package com.zero.logistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SpringMVCConfig
 * @Description TODO
 * @Author zero
 * @Date 2020/3/19 22:35
 * @Version 1.0
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("sys/login");
        registry.addViewController("/index").setViewName("sys/index");
        registry.addViewController("/customerList").setViewName("customer/customerlist");
        registry.addViewController("/addressList").setViewName("address/list");
        registry.addViewController("/dotAdd").setViewName("dot/add");
        registry.addViewController("/dotList").setViewName("dot/list");
        registry.addViewController("/priceList").setViewName("price/list");
    }
}