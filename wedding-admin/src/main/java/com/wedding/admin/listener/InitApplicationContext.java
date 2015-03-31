package com.wedding.admin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wedding.admin.init.InitAppDataHandler;
import com.wedding.common.util.SpringContextUtil;


public class InitApplicationContext implements ServletContextListener {

	protected static final Log logger = LogFactory.getLog(InitApplicationContext.class);
	
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("###### wedding-admin application start ######");
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); 
		InitAppDataHandler handler = SpringContextUtil.getBean("initAppDataHandler");
		handler.prepareDate();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	
	}

}
