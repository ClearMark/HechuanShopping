package com.kedom.common.entity;

import lombok.Getter;

@Getter
public enum KedomResponseCodeEnum {
    SUCCESS(2000,"处理成功"),
    ERROR_SERVER(5005,"服务器内部发生错误");

    private final Integer code;
    private final String message;


    KedomResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
