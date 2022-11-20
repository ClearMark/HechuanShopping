package com.kedom.common.entity.KedomUserException;

import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.common.entity.exceptionEnum.OperationExceptionMark;


public class KedomUserException extends RuntimeException implements OperationExceptionMark {
    private final KedomExceptionEnum kedomExceptionEnum;

    public KedomUserException(KedomExceptionEnum kedomExceptionEnum) {
        super(kedomExceptionEnum.getExceptionMessage());
        this.kedomExceptionEnum = kedomExceptionEnum;
    }
}
