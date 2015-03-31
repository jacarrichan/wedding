package com.wedding.admin.manager.service;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.AdminUserLoginInfoDto;

@Service
public interface IAdminAccountLoginService {

	AdminUserLoginInfoDto findAdminUserLoginInfo(String accountCode);
	
	AdminUserLoginInfoDto initAdminUserLoginInfo(String accountCode);
	
}
