package com.jhzz.gulimall.product.exception;

import com.jhzz.common.exception.BizCodeEnum;
import com.jhzz.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/7/17
 * \* Time: 14:35
 * \* Description:  集中处理所有异常
 * \
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.jhzz.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题：{},异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((error)->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION).put("data",errorMap);
    }
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable e){

        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION);
    }
}
