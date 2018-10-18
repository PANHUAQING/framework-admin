package com.frame.admin.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.admin.common.ConstantEntity;
import com.frame.admin.common.ResultEntity;
/**
 * 
* @ClassName: GlobalDefinedException
* @Description: 
*    全局异常处理
* @author panhuaqing
* @date 2018年8月9日 上午10:05:35
*
 */
@ControllerAdvice
public class GlobalDefinedException {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalDefinedException.class); 
	/**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultEntity errorHandler(Exception e) {
    	logger.info("程序发生异常...................");
    	ResultEntity result = new  ResultEntity();
    	result.setResultCode(ConstantEntity.FAIL);
    	result.setResultMsg(e.getMessage());
    	e.printStackTrace();
    	
        return result;
    }
    
    /**
     * 拦截捕捉自定义异常 
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = UserDefinedException.class)
    public ResultEntity myErrorHandler(UserDefinedException e) {
    	logger.info("异常...................");
    	ResultEntity result = new  ResultEntity();
    	result.setResultCode(ConstantEntity.FAIL);
    	result.setResultMsg(e.getMessage());
    	e.printStackTrace();
    	
        return result;
    }

}
