package com.wedding.user.dao;

import java.util.List;

import com.wedding.user.dto.UserAccountInfoDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.wedding.common.constants.DataStatus;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.mapper.UserAccountMapper;
import com.wedding.user.pojo.UserAccount;
import com.wedding.user.pojo.UserAccountExample;
import com.wedding.user.pojo.UserAccountExample.Criteria;

@Repository
public class UserAccountDao extends MyBatisBaseDao<UserAccount> {

	@Autowired
	@Getter
	private UserAccountMapper mapper;
	
	
	public UserAccount findByUsernameAndPassword(String accountName,String password){
		UserAccountExample example = new UserAccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(password);
        criteria.andUserAccountEqualTo(accountName);
		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<UserAccount> results = mapper.selectByExample(example);
		return CollectionUtils.isEmpty(results) ? null : results.get(0);
	}

    public int updateUserAccount(UserAccount userAccount) {
        return mapper.updateByPrimaryKey(userAccount);
    }

    public int updateUserAccountByAccountName(UserAccount userAccount) {
        UserAccountExample example = new UserAccountExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(userAccount.getUserAccount());
        return mapper.updateByExampleSelective(userAccount,example);
    }

    public UserAccount findUserByName(String accountName){
        UserAccountExample example = new UserAccountExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(accountName);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        List<UserAccount> results = mapper.selectByExample(example);
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

    public UserAccount findUserByAccountId(String userAccountId){
        UserAccountExample example = new UserAccountExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userAccountId);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        List<UserAccount> results = mapper.selectByExample(example);
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }
}
