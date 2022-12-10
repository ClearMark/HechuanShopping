package com.kedom.productService.aop;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.util.IDUtil;
import com.kedom.productService.util.LuaClass;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
@Aspect
@Slf4j
public class VerifyAPIRequestCodeAspect {

    @Resource
    RedissonClient redissonClient;


    private final String APIRequestCodePrefix = "APIRequestCode";

    @Pointcut("@annotation(com.kedom.productService.aop.ann.VerifyAPIRequestCode)")
    public void pc1() {
    }

    @Around("pc1()")
    public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        try {
            Long token = IDUtil.getId();
            String redisKey = token + APIRequestCodePrefix;
            String code = (String) args[0];
            ArrayList<Object> keys = new ArrayList<>(1);
            keys.add(redisKey);

            log.debug("Redis调用Lua{}", args);
            Object eval = redissonClient.getScript().eval(RScript.Mode.READ_WRITE, LuaClass.verifyAPI, RScript.ReturnType.BOOLEAN, keys, code);
            log.debug("Redis调用Lua完成返回{}", eval);

            //用Lua脚本代替
//            RBucket<Object> bucket = redissonClient.getBucket(APIRequestCodePrefix + token);
//            String APICode = (String)bucket.get();
//            bucket.delete();

            //TODO 验证码已使用或者错误
            if ((Boolean) eval) {
                log.debug("执行");
                return proceedingJoinPoint.proceed();
            }
        } catch (Exception e) {
            log.debug("验证码解析错误");
        }
        log.debug("Token与Code不对应");
        throw new KedomException(KedomExceptionEnum.API_REQUEST_CODE_ERROR);

    }
}
