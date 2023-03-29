package com.kedom.productService.aop;

public interface IParseFunction {
    default boolean executeBefore(){
        return false;
    }

    String functionName();

    String apply(String value);
}

