package com.springboot.common.servlet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title: MyWebMvcConfiger
 * @Description: 配置拦截器
 * @Author: jiangwg
 * @CreateDate: 2020/7/10 10:16
 * @Version: 1.0
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(new ServletInterceptor())
                // 拦截路径
                .addPathPatterns("/**")
                // 排除拦截的接口
                .excludePathPatterns("/userController/login","/userController/ceShi","/userController/register","/sysController/loginLog")
                // 排除静态资源拦截
                .excludePathPatterns("/css/**","/js/**","/images/**","/uploadPicture/**","/*.html");
    }
}
