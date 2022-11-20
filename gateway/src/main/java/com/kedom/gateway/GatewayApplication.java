package com.kedom.gateway;

import com.kedom.openFeignService.configClass.FeignConfig;
import com.kedom.openFeignService.feignClient.AuthFeignService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients(clients = {AuthFeignService.class},defaultConfiguration = FeignConfig.class)
public class GatewayApplication {



    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
