package com.wedding.admin.handler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.admin.manger.dto.AdminUserLoginInfoDto;
import com.wedding.common.constants.SessionConstants;
import com.wedding.common.exception.BusinessException;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.JsonUtil;
import com.wedding.common.util.LogWriter;
import com.wedding.common.util.StringUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.logger.dto.BusinessExceptionDto;
import com.wedding.logger.dto.SystemExceptionDto;
import com.wedding.logger.service.IExceptionLoggerService;

/**
 * 统一异常处理器
 * @author rkzhang
 */
public class ExceptionHandler implements HandlerExceptionResolver  {

	@Autowired
	private IExceptionLoggerService exceptionLoggerService;
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
			String requestUrl = request.getRequestURI();
			AdminUserLoginInfoDto user = (AdminUserLoginInfoDto) request.getSession().getAttribute(SessionConstants.ADMIN_USER_ID);
		
	        ex.printStackTrace();
	        String message = null;
	        // 根据不同错误转向不同页面  
	        if(ex instanceof BusinessException) {         	
	        	message = handleBusinessException(request, ex, requestUrl, user);
	        	
	        } else {  	     
	        	message = ex.getMessage();
	        	handleSystemException(ex);
	        }  
	        
	        try {
	        	response.setContentType("application/json");
	        	response.setCharacterEncoding("utf-8");
				response.getWriter().print(JsonUtil.getJsonStr(new RequestResult(false, message)));
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			};
           
	        return new ModelAndView();  
	}

	private void handleSystemException(Exception ex) {
		SystemExceptionDto set = new SystemExceptionDto();
		set.setId(UUIDGenerator.getUUID());
		set.setCreateTime(new Date());
		set.setErrorMessage(StringUtils.isEmpty(ex.getMessage()) ? "None" : ex.getMessage());
		set.setErrorStackTrace(LogWriter.getStackMsg(ex.getStackTrace()));
		exceptionLoggerService.pushSystemException(set);
	}

	private String handleBusinessException(HttpServletRequest request,
			Exception ex, String requestUrl, AdminUserLoginInfoDto user) {
		BusinessExceptionDto bet = BusinessExceptionDto.createBusinessException((BusinessException)ex);
		bet.setRequestParams(request.getParameterMap().toString());
		bet.setRequestUrl(requestUrl);
		bet.setErrorStackTrace(LogWriter.getStackMsg(ex.getStackTrace()));
		if(user != null){
			bet.setLoginUserAccount(user.getAccountCode());	   
		}else{
			bet.setLoginUserAccount("None");
		}
		exceptionLoggerService.pushBusinessException(bet);
		return bet.getErrorMessage();
	}
}
