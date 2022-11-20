package com.kedom.authService.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson(){
        Config config = new Config();
        // 创建单例模式的配置
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }
    @Bean
    public Gson gson()
    {
        Gson gson=  new GsonBuilder()
                .serializeNulls()
                .create();
        return gson;
    }


}
