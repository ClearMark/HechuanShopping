package com.kedom.common.entity;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import lombok.Data;

@Data
public class KedomResponse {

    private Integer code;  //错误代码
    private String message;  //错误信息
    private Object data;
    private Integer total = null;

    public KedomResponse(KedomResponseCodeEnum codeEnum) {
        this.setCode(codeEnum.getCode());
        this.setMessage(codeEnum.getMessage());
    }

    public KedomResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static KedomResponse error(Integer code, String message) {
        return new KedomResponse(code, message);
    }


    public KedomResponse fillCode(KedomResponseCodeEnum codeEnum) {
        this.setCode(codeEnum.getCode());
        this.setMessage(codeEnum.getMessage());
        return this;
    }

    public KedomResponse fillCode(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public KedomResponse fillCode(KedomUserException kedomUserException) {
        this.setCode(888);
        this.setMessage(kedomUserException.getMessage());
        return this;
    }

    public KedomResponse fillCode(String message) {
        this.setMessage(message);
        return this;
    }

    public KedomResponse fillData(Object data) {
        this.setCode(KedomResponseCodeEnum.SUCCESS.getCode());
        this.setMessage(KedomResponseCodeEnum.SUCCESS.getMessage());
        this.data = data;
        return this;
    }

    public static KedomResponse OK() {
        return new KedomResponse(KedomResponseCodeEnum.SUCCESS);
    }
    public static KedomResponse OK_FULLData(Object data) {
        return new KedomResponse().fillData(data);
    }

    public static KedomResponse Error() {
        return new KedomResponse(KedomResponseCodeEnum.ERROR_SERVER);
    }

    public KedomResponse() {
    }

}



