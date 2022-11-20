package com.kedom.authService.controller;

import com.kedom.authService.entity.UmsMember;
import com.kedom.authService.service.JWTService;
import com.kedom.common.entity.KedomResponse;
import com.kedom.openFeignService.entity.vo.UserRegisterVO;
import com.kedom.openFeignService.entity.vo.UserVO;
import com.kedom.openFeignService.feignClient.MemberFeignService;
import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MemberFeignService memberFeignService;

    @Autowired
    JWTService jwtService;

    @PostMapping("/register")
    public KedomResponse register(@Valid UserRegisterVO registerVO, BindingResult bindingResult) {
        KedomResponse response = new KedomResponse();

        HashMap<String, String> parameterError = getParameterError(bindingResult);
        if (parameterError.size()!=0) {
            return  response.fillData(parameterError);
        }
        response = memberFeignService.register(registerVO);
        return response;
    }

    @PostMapping("/login")
    public KedomResponse login(@Valid UserVO userLoginVo, BindingResult bindingResult) {
        KedomResponse response = new KedomResponse();

        HashMap<String, String> parameterError = getParameterError(bindingResult);
        if (parameterError.size()!=0) {
            return  response.fillData(parameterError);
        }
        response = memberFeignService.login(userLoginVo);
        if (response.getCode().equals(2000))
        {
            String accessToken = jwtService.createAccessToken(response.getData().toString());
            HashMap<String,String> hashMap=new HashMap();
            hashMap.put("accessToken",accessToken);
            response.fillData(hashMap);
            return response;
        }
        return response;
    }

    @PostMapping("/getRedisUmsMemberByAccessToken")
    public Boolean getRedisUmsMemberByAccessToken(@RequestBody String accessToken) {
        return jwtService.verificationUmsMemberAccessToken(accessToken);
    }



    private HashMap<String,String> getParameterError(BindingResult bindingResult) {
        HashMap<String,String> errorMap=new HashMap<>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });

         return errorMap;
    }



}
