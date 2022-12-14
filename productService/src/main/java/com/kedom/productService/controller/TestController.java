package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.aop.ann.VerifyAPIRequestCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @PostMapping("/A")
    @VerifyAPIRequestCode
    public KedomResponse a(@RequestHeader("Code") String Code
    ) {
        log.debug("到达拦截器");
        return KedomResponse.ok();
    }


}
