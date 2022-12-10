package com.kedom.authService.controller;

import com.kedom.authService.entity.MailMessage;
import com.kedom.authService.entity.TokenAndUserID;
import com.kedom.authService.service.JWTService;
import com.kedom.authService.service.MailService;
import com.kedom.authService.util.AuthTool;
import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.openFeignService.entity.vo.UserVO;
import com.kedom.openFeignService.entity.vo.validationGroup.Login;
import com.kedom.openFeignService.entity.vo.validationGroup.Register;
import com.kedom.openFeignService.feignClient.MemberFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public KedomResponse register(@Validated(Register.class) @RequestBody UserVO registerVO, BindingResult bindingResult) {

        HashMap<String, String> parameterError = getParameterError(bindingResult);
        if (parameterError.size() != 0) {
            return KedomResponse.errorAddData(parameterError);
        }

        String code = registerVO.getCode();
        String email = registerVO.getEmail();
        String redisCode = mailService.mailCodeDownloadRedis(email, 1);

        if (!code.equals(redisCode)) {
            return new KedomResponse(KedomExceptionEnum.VERIFY_CODE_ERROR);
        }

        return memberFeignService.register(registerVO);
    }

    @PostMapping("/login")
    public KedomResponse login(@Validated(Login.class) @RequestBody UserVO userLoginVo, BindingResult bindingResult) {


        HashMap<String, String> parameterError = getParameterError(bindingResult);
        if (parameterError.size() != 0) {
            KedomResponse kedomResponse = new KedomResponse(KedomExceptionEnum.REQUEST_PARAMETER_ERROR);
            kedomResponse.setData(parameterError);
            return kedomResponse;
        }

        KedomResponse kedomResponse = memberFeignService.login(userLoginVo);
        if (kedomResponse.getCode().equals(8888)) {
            Object userData = kedomResponse.getData();
            String accessToken = jwtService.createAccessToken(kedomResponse.getData().toString());
            HashMap<String, String> hashMap = new HashMap();
            hashMap.put("userData", userData.toString());
            hashMap.put("Token", accessToken);
            kedomResponse.setData(hashMap);
            return kedomResponse;
        }
        return kedomResponse;
    }

    @GetMapping("/MailCode/{sendTo}/{type}")
    public KedomResponse MailCode(@PathVariable("sendTo") String to, @PathVariable("type")String type) {

        String code = AuthTool.randomCode();

        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("验证码");
        mailMessage.setText("您的验证码为：" + code);
        mailMessage.setType(type);
        if (mailMessage.getType() == null) {
            return KedomResponse.errorAddData("验证码来源不能为空");
        }
        mailService.mailCodeUploadRedis(mailMessage, code);
        mailService.sendTextMailMessage(mailMessage);

        return KedomResponse.ok();
    }

    @PostMapping("/TokenAndUserDataVerify")
    public KedomResponse MailCode(@RequestBody TokenAndUserID tokenAndUserID) {
        jwtService.TokenAndUserDataVerify(tokenAndUserID);
        return KedomResponse.ok();
    }

    @PostMapping("/getRedisUmsMemberByAccessToken")
    public Boolean getRedisUmsMemberByAccessToken(@RequestBody String accessToken) {
        return jwtService.verificationUmsMemberAccessToken(accessToken);
    }

    @GetMapping("getAPIRequestCode")
    public KedomResponse getAPIRequestCode(@RequestHeader("Token") String accessToken) {
        String code = jwtService.getAPIRequestCode(accessToken);
        return KedomResponse.okAddData(code);
    }


    private HashMap<String, String> getParameterError(BindingResult bindingResult) {
        HashMap<String, String> errorMap = new HashMap<>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

         return errorMap;
    }



}
