package com.frame.admin.listener;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{
	
	//日志
    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("#########################session创建######################");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		logger.info("#########################session消亡######################");
		logger.info("---sessionCreated----");
        HttpSession session = sessionEvent.getSession();
        ServletContext application = session.getServletContext();
        // 在application范围由一个HashSet集保存所有的session
        HashSet sessions = (HashSet) application.getAttribute("sessions");
        if (sessions == null) {
            sessions = new HashSet();
            application.setAttribute("sessions", sessions);
        }
        String userName =  session.getAttribute("user").toString();
        // 新创建的session均添加到HashSet集中
       sessions.add(session);
        // 可以在别处从application范围中取出sessions集合
        // 然后使用sessions.size()获取当前活动的session数，即为“在线人数”

		logger.info("###############################################"+userName);
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		 logger.info("--attributeAdded--");
	        HttpSession session = httpSessionBindingEvent.getSession();
	        logger.info("key----:"+httpSessionBindingEvent.getName());
	        logger.info("value---:"+httpSessionBindingEvent.getValue());

		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		 logger.info("--attributeRemoved--");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		logger.info("--attributeReplaced--");
		
	}

}
