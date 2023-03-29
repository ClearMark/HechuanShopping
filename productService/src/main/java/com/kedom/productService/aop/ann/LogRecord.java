package com.kedom.productService.aop.ann;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogRecord {
    String success(); //    success 操作日志的文本模板 是

    String fail() default ""; //    fail 操作日志失败的文本版本 否

    String operator() default ""; //    operator 操作日志的执行人 否

    String bizNo() default ""; //    bizNo 操作日志绑定的业务对象标识 是

    String category() default ""; //    category 操作日志的种类 否

    String detail() default ""; //    detail 扩展参数，记录操作日志的修改详情 否

    String condition() default "";//    condition 记录日志的条件 否









}
