package com.kedom.openFeignService.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserVO {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
