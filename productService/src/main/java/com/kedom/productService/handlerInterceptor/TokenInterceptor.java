package com.kedom.productService.handlerInterceptor;

import com.kedom.productService.util.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            response.setStatus(401);
            return false;
        }
        log.info("用户id{}访问了商品服务", token);
        IDUtil.setId(Long.parseLong(token));
        return true;
    }
}

