package com.wedding.admin.manager.service;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.AdminAccountDto;
import com.wedding.admin.manger.dto.AdminAccountQuery;
import com.wedding.admin.manger.dto.ResetPasswdQuery;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;

@Service
public interface IAdminAccountService {

	AdminAccountDto findAdminAccountByUsername(String username);
	
	long countAll();
	
	PageResult<AdminAccountDto> findAllByPage(PageQuery page);
	
	PageResult<AdminAccountDto> find(AdminAccountQuery query,PageQuery page);
	
	RequestResult save(AdminAccountDto account);
	
	RequestResult update(AdminAccountDto account);

	RequestResult delete(String accountId);

	RequestResult resetPasswd(String accountId);

	RequestResult resetPasswd(ResetPasswdQuery query);
	
}
