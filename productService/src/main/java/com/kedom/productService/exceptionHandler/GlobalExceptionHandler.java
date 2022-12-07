package com.kedom.productService.exceptionHandler;

import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.KedomUserException.KedomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(KedomException.class)
    public KedomResponse processBusinessException(KedomException userException) {
        log.error(userException.getLocalizedMessage(), userException);
        // 这里可以屏蔽掉后台的异常栈信息，直接返回"business error"
        return new KedomResponse(userException);
    }
}
