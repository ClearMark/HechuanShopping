package com.kedom.productService.config;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.RedissonCacheMetrics;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class RedisCacheConfig {
    @Bean
    public CacheManager redisCacheManager(RedissonClient redissonClient) {
        RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(redissonClient);

        return cacheManager;
    }
}
