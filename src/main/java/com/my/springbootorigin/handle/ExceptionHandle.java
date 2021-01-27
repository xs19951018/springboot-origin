package com.my.springbootorigin.handle;

import com.my.springbootorigin.utils.ResultVOUtil;
import com.my.springbootorigin.common.exception.BaseErrorException;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof BaseErrorException) {
            BaseErrorException errorException = (BaseErrorException) e;
            return ResultVOUtil.error(errorException.getCode(), errorException.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }

}
