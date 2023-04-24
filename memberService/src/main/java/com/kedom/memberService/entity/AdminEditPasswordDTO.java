package com.kedom.memberService.entity;

import lombok.Data;

@Data
public class AdminEditPasswordDTO {
    private Integer id;
    private String oldPassword;
    private String newPassword;
}
