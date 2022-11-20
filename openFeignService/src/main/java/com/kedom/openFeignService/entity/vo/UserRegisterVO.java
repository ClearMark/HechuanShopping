package com.kedom.openFeignService.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegisterVO extends UserVO {
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    @NotEmpty(message = "验证码不能为空")
    private String code;
}
