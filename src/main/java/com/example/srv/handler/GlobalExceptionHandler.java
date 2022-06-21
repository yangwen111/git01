package com.example.srv.handler;

import com.example.srv.controller.BaseRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author
 * @DATE 2022/6/21 -14:36
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseRes handleExcp(Exception e){
        BaseRes<Object> baseRes = new BaseRes<>();
        baseRes.setCode("999");
        baseRes.setResult(null);
        baseRes.setMsg("操作失败");
        baseRes.setSuccess(false);
        logger.error(e.getMessage(),e);
        return baseRes;
    }
}
