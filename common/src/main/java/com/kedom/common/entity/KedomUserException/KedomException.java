package com.kedom.common.entity.KedomUserException;

import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.common.entity.exceptionEnum.OperationExceptionMark;
import lombok.Data;


@Data
public class KedomException extends RuntimeException implements OperationExceptionMark {
    private final KedomExceptionEnum kedomExceptionEnum;

    public KedomException(KedomExceptionEnum kedomExceptionEnum) {
        super(kedomExceptionEnum.getExceptionMessage());
        this.kedomExceptionEnum = kedomExceptionEnum;
    }
}
