package com.he.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    /**
     * 解决跨域问题,设计token登录验证时建议使用过滤的形式，优先级更高
     */
    @Override
    public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**")  // 拦截所有的请求
                    .allowedOrigins("*")  // 可跨域的域名，可以为 *
                    .allowCredentials(true)
                    .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")   // 允许跨域的方法，可以单独配置
                    .allowedHeaders("*");  // 允许跨域的请求头，可以单独配置
        }
}
