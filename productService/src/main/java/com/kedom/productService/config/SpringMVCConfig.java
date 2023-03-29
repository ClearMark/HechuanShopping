package com.kedom.productService.config;

import com.kedom.productService.handlerInterceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Resource
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/**.ico");
    }

    @Override
         public void addResourceHandlers(ResourceHandlerRegistry registry) {
                   /**
                      * 资源映射路径
                      * addResourceHandler：访问映射路径
                      * addResourceLocations：资源绝对路径
                      */      registry.addResourceHandler("/productService/productImage/**").addResourceLocations("file:C:/productImage/");
                }

}
