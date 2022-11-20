package com.kedom.openFeignService.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegisterVO extends UserVO {
    @NotEmpty(message = "手机号不能为空")
    private String mobile;
    @NotEmpty(message = "验证码不能为空")
    private String code;
}
