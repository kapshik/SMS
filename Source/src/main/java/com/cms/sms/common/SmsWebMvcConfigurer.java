package com.cms.sms.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SmsWebMvcConfigurer implements WebMvcConfigurer {
   @Autowired
   SmsHandlerInterceptor smsHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(smsHandlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/templates/**", "/report/**");
    }

}
