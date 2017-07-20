package com.ganpai.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义拦截器 配置类
 * Created by Administrator on 2017/7/13 0013.
 */
@EnableWebMvc
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{

    @Bean
    UserSecurityInterceptor userSecurityInterceptor() {
        return new UserSecurityInterceptor();
    }

    @Bean
    AccessInterceptor accessInterceptor(){
        return new AccessInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userSecurityInterceptor()).addPathPatterns("/**").excludePathPatterns("/error/**")
                                    .excludePathPatterns("/user/lookingByMobile")
                                    .excludePathPatterns("/user/sendMobile")
                                    .excludePathPatterns("/user/validMobileCode");

        registry.addInterceptor(accessInterceptor()).addPathPatterns("/recommend/**")
                .addPathPatterns("/like/**").addPathPatterns("/collection/**")
                .addPathPatterns("/demand/**").addPathPatterns("/task/**");
    }
}
