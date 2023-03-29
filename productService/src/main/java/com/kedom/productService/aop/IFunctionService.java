package com.kedom.productService.aop;

public interface IFunctionService {
    String apply(String functionName, String value);

    boolean beforeFunction(String functionName);
}
