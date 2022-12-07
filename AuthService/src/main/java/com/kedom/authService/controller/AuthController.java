package com.kedom.authService.controller;

import com.kedom.authService.entity.MailMessage;
import com.kedom.authService.service.JWTService;
import com.kedom.authService.service.MailService;
import com.kedom.authService.util.AuthTool;
import com.kedom.common.entity.KedomResponse;
import com.kedom.openFeignService.entity.vo.UserRegisterVO;
import com.kedom.openFeignService.entity.vo.UserVO;
import com.kedom.openFeignService.feignClient.MemberFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private MemberFeignService memberFeignService;

    @Autowired
    private MailService mailService;

    @Autowired
    JWTService jwtService;

    @PostMapping("/register")
    public KedomResponse register(@Valid UserRegisterVO registerVO, BindingResult bindingResult) {
        KedomResponse response = new KedomResponse();
        HashMap<String, String> parameterError = getParameterError(bindingResult);
        if (parameterError.size()!=0) {
            return  response.fillData(parameterError);
        }

        String code = registerVO.getCode();
        String email = registerVO.getEmail();
        String redisCode = mailService.mailCodeDownloadRedis(email, 1);
        if (!code.equals(redisCode)) {
            response.setCode(500);
            response.setMessage("验证码错误");
            return response;
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

    @PostMapping("/MailCode/{sendTo}/{type}")
    public KedomResponse MailCode(@PathVariable("sendTo") String to, @PathVariable("type")String type) {
        KedomResponse response = new KedomResponse();
        String code = AuthTool.randomCode();

        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("验证码");
        mailMessage.setText("您的验证码为："+code);
        mailMessage.setType(type);
        if (mailMessage.getType()==null)
        {
            return response.fillData("验证码来源不能为空");
        }
        mailService.mailCodeUploadRedis(mailMessage, code);
        mailService.sendTextMailMessage(mailMessage);

        return KedomResponse.OK_FULLData(code);
    }

    @PostMapping("/getRedisUmsMemberByAccessToken")
    public Boolean getRedisUmsMemberByAccessToken(@RequestBody String accessToken) {
        return jwtService.verificationUmsMemberAccessToken(accessToken);
    }

    @GetMapping("getAPIRequestCode")
    public KedomResponse getAPIRequestCode(@RequestHeader("Token") String accessToken) {
        String code = jwtService.getAPIRequestCode(accessToken);
        return KedomResponse.OK_FULLData(code);
    }


    private HashMap<String, String> getParameterError(BindingResult bindingResult) {
        HashMap<String, String> errorMap = new HashMap<>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

         return errorMap;
    }



}
