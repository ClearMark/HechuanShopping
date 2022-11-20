package com.kedom.authService;

import com.kedom.openFeignService.configClass.FeignConfig;
import com.kedom.openFeignService.feignClient.MemberFeignService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {MemberFeignService.class},defaultConfiguration = FeignConfig.class)
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
