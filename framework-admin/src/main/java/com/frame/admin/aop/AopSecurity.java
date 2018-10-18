package com.frame.admin.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.frame.admin.common.ResultEntity;
/**
 * 
* @ClassName: AopSecurity
* @Description: 
*    使用aop 实现用户登录拦截 
* @author panhuaqing
* @date 2018年8月16日 下午4:51:20
*
 */
@Component
@Aspect
public class AopSecurity {
	
	//日志
	private final Logger logger = LoggerFactory.getLogger(AopSecurity.class);
	
	//增加切点 对登录控制类 所有的操作 进行拦截
	@Pointcut("execution(public * com.frame.admin.controller.*.*(..))")
    public void login() {
    }
     
	//前置通知 
	 @Before("login()")
	 public void deoBefore(JoinPoint joinPoint) {
	     logger.info("方法执行前进行打印输出...");
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        logger.info("url:" + request.getRequestURI());
        logger.info("ip:" + request.getRemoteHost());
        logger.info("method:" + request.getMethod());
        logger.info("class_method:" + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("args:" + joinPoint.getArgs());
	    }

	    //后置通知
	    @After("login()")
	    public void doAfter(JoinPoint joinPoint) {
	        logger.info("方法执行后...");
	    }

	    //返回值
	    @AfterReturning(returning = "result", pointcut = "login()")
	    public void doAfterReturning(Object result) {
	        logger.info("执行返回值：" + result);
	    }
        
	    //环绕通知
	    @Around("login()")
	    public Object trackInfo(ProceedingJoinPoint point) throws Throwable {

	        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = sra.getRequest();
	        HttpSession session = request.getSession();
	        logger.info("环绕通知后...");
	        //Login loginByIp = loginDao.getLoginByIp(remoteHost);
	       /* if (session.getAttribute("user")==null) {
	            logger.info("-------------没有登录-------------");
	            return new ResultEntity("8888","登录失败!",null,0);
	        } else {
	            logger.info("-------------登录通过-------------");
	        }*/
	        return point.proceed();
	    }
}
