package com.kedom.authService.entity;

import lombok.Data;

@Data
public class TokenAndUserID {
    private String token;
    private Long userID;

}
