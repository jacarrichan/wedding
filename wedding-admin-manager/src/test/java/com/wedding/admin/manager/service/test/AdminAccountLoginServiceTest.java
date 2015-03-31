package com.wedding.admin.manager.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.wedding.admin.manager.service.IAdminAccountLoginService;
import com.wedding.admin.manager.test.BaseTestCase;
import com.wedding.admin.manger.dto.AdminUserLoginInfoDto;
import com.wedding.common.redis.WdRedisDao;

public class AdminAccountLoginServiceTest extends BaseTestCase {
	
	@Autowired
	private IAdminAccountLoginService loginService;
	
	@Autowired
	private WdRedisDao<AdminUserLoginInfoDto> loginInfoRedisDao;
	
	@Test
	public void findAdminUserLoginInfo(){
		String accountCode = "admin999";
		
		AdminUserLoginInfoDto userLoginInfo = loginService.findAdminUserLoginInfo(accountCode);
		userLoginInfo = loginInfoRedisDao.get(userLoginInfo.getAccountCode(), AdminUserLoginInfoDto.class);
		System.out.println(userLoginInfo);
	}
}
