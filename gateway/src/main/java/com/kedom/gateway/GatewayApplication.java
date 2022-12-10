package com.kedom.gateway;

import com.kedom.openFeignService.configClass.FeignConfig;
import com.kedom.openFeignService.feignClient.AuthFeignService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {AuthFeignService.class},defaultConfiguration = FeignConfig.class)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
