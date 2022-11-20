package com.kedom.memberService.MemberExceptionResolver;


import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.exceptionEnum.OperationExceptionMark;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

//MVC全局异常处理器
@ControllerAdvice
public class memberExceptionResolver implements HandlerExceptionResolver {
//    @Autowired
//    private ExceptionLogDao exceptionLogDao;

//    @Autowired
//    private Gson gson;

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        KedomResponse kedomResponse = new KedomResponse();
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String exceptionMessage = e.getMessage();

        if (e instanceof OperationExceptionMark) //判断是否是用户引起的异常 决定是否加入数据库
        {
            kedomResponse.fillCode(3000,exceptionMessage);
            System.out.println("用户引起的异常");
        } else {
//            String exceptionURL = httpServletRequest.getRequestURL().toString();
//            String exceptionClassName = stackTraceElement.getClassName();
//            String exceptionMethodName = stackTraceElement.getMethodName();
//            LocalDateTime now = LocalDateTime.now();
//            ExceptionLog exceptionLog = new ExceptionLog(exceptionURL, exceptionClassName, exceptionMethodName, exceptionMessage, now);
//            exceptionLogDao.insert(exceptionLog);
//
//            response.fillCode(CodeEnum.ERROR_SERVER);
//            response.setMessage("服务器异常");
            kedomResponse.fillCode(3001,exceptionMessage);
            System.out.println("服务器异常");
        }



//        try {
//            httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
//            httpServletResponse.setCharacterEncoding("UTF-8");
//            httpServletResponse.getWriter().write(gson.toJson(response));
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
        return new ModelAndView();
    }
}
