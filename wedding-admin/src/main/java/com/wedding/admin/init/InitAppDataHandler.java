package com.wedding.admin.init;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedding.admin.manager.handler.AdminUserAccountPump;
import com.wedding.logger.handler.BusinessExceptionHandler;
import com.wedding.logger.handler.SystemExceptionHandler;
import com.wedding.tools.pump.AreaDtoPump;

@Service
public class InitAppDataHandler {

	protected static final Log logger = LogFactory.getLog(InitAppDataHandler.class);
	
	@Autowired
	private AdminUserAccountPump accountPump;
	
	@Autowired
	private AreaDtoPump areaPump;
	
	@Autowired
	private BusinessExceptionHandler businessExceptionHandler;
	
	@Autowired
	private SystemExceptionHandler systemExceptionHandler;
	
	public void prepareDate(){
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(accountPump);	//管理员登录账号信息初始化
		es.execute(areaPump);		//地区代码初始化
		es.execute(businessExceptionHandler);	//业务逻辑错误记录线程
		es.execute(systemExceptionHandler);		//系统错误记录线程
	}
	
	/**
	 * 重置所有管理员登录信息
	 */
	public void reflushAdminUserAccount(){
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(accountPump);
	}
	
}
