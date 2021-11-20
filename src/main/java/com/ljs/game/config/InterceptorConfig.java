package com.ljs.game.config;

import com.ljs.game.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")//拦截所有的路径
                .excludePathPatterns("/admin/login");
//        .excludePathPatterns("/core/student/down")
//        super.addInterceptors(registry);
    }
}
