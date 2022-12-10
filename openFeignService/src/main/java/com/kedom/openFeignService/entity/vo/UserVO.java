package com.kedom.openFeignService.entity.vo;

import com.kedom.openFeignService.entity.vo.validationGroup.Login;
import com.kedom.openFeignService.entity.vo.validationGroup.Register;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserVO {
    @NotEmpty(message = "用户名不能为空", groups = {Register.class, Login.class})
    private String username;
    @NotEmpty(message = "密码不能为空", groups = {Register.class, Login.class})
    private String password;
    @NotEmpty(message = "邮箱不能为空", groups = {Register.class})
    private String email;
    @NotEmpty(message = "验证码不能为空", groups = {Register.class})
    private String code;
}
