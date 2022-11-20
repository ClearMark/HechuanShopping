package com.kedom.openFeignService.feignClient;

import com.kedom.openFeignService.entity.vo.UmsMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "authService")
public interface AuthFeignService {
    @PostMapping("/auth/getRedisUmsMemberByAccessToken")
    public Boolean getRedisUmsMemberByAccessToken(@RequestBody String accessToken);
}
