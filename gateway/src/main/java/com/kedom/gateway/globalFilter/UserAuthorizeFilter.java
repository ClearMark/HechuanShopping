package com.kedom.gateway.globalFilter;

import com.kedom.openFeignService.feignClient.AuthFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class UserAuthorizeFilter implements GlobalFilter {

    @Autowired
    AuthFeignService authFeignService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        if (exchange.getRequest().getURI().getPath().contains("auth")) {
//            return chain.filter(exchange);
//        }
//
//        HttpHeaders headers = exchange.getRequest().getHeaders();
//        String accessToken = headers.getFirst("accessToken");
//        if (accessToken == null) {
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.FORBIDDEN);
//            return response.setComplete();
//        }
//        Boolean redisUmsMember = authFeignService.getRedisUmsMemberByAccessToken(accessToken);
//        if (!redisUmsMember) {
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.FORBIDDEN);
//            return response.setComplete();
//        }
        System.out.println("aa");
        return chain.filter(exchange);
    }
}
