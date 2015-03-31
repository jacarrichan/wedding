package com.wedding.admin.manager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;

import com.wedding.admin.manager.mapper.AccountActionMapper;
import com.wedding.admin.manager.pojo.AccountAction;
import com.wedding.common.mybatis.MyBatisBaseDao;

@Repository
public class AccountActionDao extends MyBatisBaseDao<AccountAction>{

	@Autowired
	@Getter
	private AccountActionMapper mapper;
	
	
	
}
