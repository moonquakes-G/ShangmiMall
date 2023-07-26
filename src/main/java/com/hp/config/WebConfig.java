package com.hp.config;

import com.hp.controller.interceptor.BackendLoginInterceptor;
import com.hp.controller.interceptor.FrontendLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Curtain-call
 * 配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/").setViewName("admin");
        registry.addViewController("/index/").setViewName("index");
    }

    /**注册拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除登录请求，和登录表单处理请求，以及静态资源
//        registry.addInterceptor(new BackendLoginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/admin/","/**/toLogin","/index/","/index/toRegister","/**/login","/index/register",
//                        "/**/css/**","/**/js/**","/**/img/**");

//        registry.addInterceptor(new FrontendLoginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index/","/**/toLogin","/index/login",
//                        "/index/toRegister","/**/css/**","/**/js/**","/**/img/**");
    }
}
