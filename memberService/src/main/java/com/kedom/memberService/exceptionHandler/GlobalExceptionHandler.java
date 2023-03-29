package com.kedom.memberService.exceptionHandler;

import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.KedomUserException.KedomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KedomException.class)
    public KedomResponse processBusinessException(KedomException kedomException) {
        // 这里可以屏蔽掉后台的异常栈信息，直接返回"business error"
        log.info(kedomException.getKedomExceptionEnum().getExceptionMessage());
        return new KedomResponse(kedomException);
    }

    @ExceptionHandler(Exception.class)
    public KedomResponse processSystemException(Exception e) {
        log.info("系统异常{}位置{}", e.getMessage(), e.getStackTrace()[0]);
        return KedomResponse.error();
    }


}
