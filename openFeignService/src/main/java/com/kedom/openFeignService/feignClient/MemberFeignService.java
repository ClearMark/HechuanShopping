package com.kedom.openFeignService.feignClient;

import com.kedom.common.entity.KedomResponse;
import com.kedom.openFeignService.entity.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "memberService")
public interface MemberFeignService {

    @PostMapping("/umsMember/register")
    KedomResponse register(@RequestBody UserVO registerVO);

    @PostMapping("/umsMember/login")
    KedomResponse login(@RequestBody UserVO userLoginVo);
}
