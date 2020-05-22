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
        registry.addViewController("/index").setViewName("sys/index");
        registry.addViewController("/customerTable").setViewName("customer/table");
        registry.addViewController("/customerEdit").setViewName("customer/edit");
        registry.addViewController("/addressTable").setViewName("address/table");
        registry.addViewController("/dotTable").setViewName("dot/table");
        registry.addViewController("/dotEdit").setViewName("dot/edit");
        registry.addViewController("/staffTable").setViewName("staff/table");
        registry.addViewController("/staffEdit").setViewName("staff/edit");
        registry.addViewController("/priceTable").setViewName("price/table");
        registry.addViewController("/priceEdit").setViewName("price/edit");
        registry.addViewController("/orderTable").setViewName("order/table");
        registry.addViewController("/orderDetail").setViewName("order/detail");
        registry.addViewController("/waybillTable").setViewName("waybill/table");
        registry.addViewController("/waybillDetail").setViewName("waybill/detail");
        registry.addViewController("/feedBackTable").setViewName("feedback/table");
        registry.addViewController("/admin/login").setViewName("sys/login");
    }
}