package com.kedom.productService.aop;

import com.kedom.productService.aop.ann.LogRecord;
import com.kedom.productService.entity.context.LogRecordContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Component
@Aspect
public class LogRecordAspect {
    private final Logger businessLog = LoggerFactory.getLogger("businessLog");

    @Pointcut("@annotation(com.kedom.productService.aop.ann.LogRecord)")
    public void pc1() {
    }

    @Around("pc1()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        LogRecordContext.putEmptySpan();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        if (LogRecordContext.getGlobalVariable("printMethod") == null) {
            LogRecordContext.putGlobalVariable("printMethod", method);
        }


        //环绕前可以做做一些事情（比如高级的获取其他信息）
        pjp.proceed();

        LogRecord logRecord = method.getAnnotation(LogRecord.class);
        String success = logRecord.success();
        String log = LogRecordSpELParse.parse(success);

        LogRecordContext.addLog(log);
        LogRecordContext.clear();

        if (LogRecordContext.getGlobalVariable("printMethod") == method) {
            List<String> logList = LogRecordContext.getLogList();
            if (logList != null) {
                for (String s : logList) {
                    businessLog.info(s);
                }
            }
            LogRecordContext.clearGlobalVariable("printMethod");
            LogRecordContext.clearLogList();
        }

    }

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void after(JoinPoint jp, Throwable e) throws Throwable {
        if (LogRecordContext.globalExistException()) {
            return;
        }
        LogRecordContext.putException(e);
        businessLog.info("异常{}" + e.getStackTrace()[0].toString());
    }

}
