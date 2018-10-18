package com.frame.admin.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
/**
 * 登录拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	   private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	      /* //获取session
	        HttpSession session = request.getSession(true);
	        //判断用户ID是否存在，不存在就跳转到登录界面
	        if(session.getAttribute("user") == null){
	            logger.info("跳转到login页面获取返回登录失败！");
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = null ;
				try{
				    JSONObject json = new JSONObject();
				    json.put("success","false");
				    json.put("msg","未登录,请登录!");
				    out = response.getWriter();
				    out.append(json.toString());
				    return false;
				}
				catch (Exception e){
				    e.printStackTrace();
				    response.sendError(500);
				}
	            //response.sendRedirect(request.getContextPath()+"/admin/login");
	            return false;
	        }else{
	        	//存放session
	            session.setAttribute("user", session.getAttribute("user"));
	            return true;
	        }
	    	 */
	    	 return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        

	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	        

	    }
}
