package com.kedom.common.entity;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import lombok.Data;


//响应体返回
@Data
public class KedomResponse {

    private Integer code;  //错误代码
    private String message;  //错误信息
    private Object data;

    private Integer total = null;


    public KedomResponse(KedomException kedomException) {
        this.code = kedomException.getKedomExceptionEnum().getExceptionCode();
        this.message = kedomException.getKedomExceptionEnum().getExceptionMessage();
    }

    public KedomResponse(KedomExceptionEnum kedomExceptionEnum) {
        this.code = kedomExceptionEnum.getExceptionCode();
        this.message = kedomExceptionEnum.getExceptionMessage();
    }


    public static KedomResponse ok() {
        KedomResponse kedomResponse = new KedomResponse();
        kedomResponse.setCode(8888);
        kedomResponse.setMessage("SUCCESS");
        return kedomResponse;
    }

    public static KedomResponse okAddData(Object data) {
        KedomResponse ok = KedomResponse.ok();
        ok.setData(data);
        return ok;
    }

    //只有失败
    public static KedomResponse error() {
        KedomResponse kedomResponse = new KedomResponse();
        kedomResponse.setCode(0000);
        kedomResponse.setMessage("ERROR");
        return kedomResponse;
    }

    //失败有数据
    public static KedomResponse errorAddData(Object data) {
        KedomResponse error = KedomResponse.error();
        error.setData(data);
        return error;
    }
    //失败 有状态有信息（异常） 建议直接new 有现成的构造函数


    public KedomResponse() {
    }

}



