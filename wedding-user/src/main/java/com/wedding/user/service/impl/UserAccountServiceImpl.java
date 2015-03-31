package com.wedding.user.service.impl;

import com.wedding.common.digest.MD5Coder;
import com.wedding.common.exception.SystemException;
import com.wedding.common.util.RandomCode;
import com.wedding.user.dao.UserAccountDao;
import com.wedding.user.dto.UserAccountDto;
import com.wedding.user.pojo.UserAccount;
import com.wedding.user.service.IUserAccountInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserAccountServiceImpl implements IUserAccountInfoService {
    @Autowired
	private UserAccountDao userAccountDao;

    @Override
    public UserAccountDto checkUser(String loginName, String loginPassword) {
        UserAccount userAccount = null;
        if(!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(loginPassword)){
            try {
                MD5Coder.encodeMD5Hex(loginPassword);
            } catch (Exception e) {
                throw new SystemException(e.getMessage(),e);
            }
            userAccount= userAccountDao.findByUsernameAndPassword(loginName, loginPassword);
        }
        UserAccountDto userAccountDto=changToDto(userAccount);
        return userAccountDto;
    }

    @Override
    public int updateUserAccount(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(userAccountDto, userAccount);
        return userAccountDao.updateByPrimaryKeySelective(userAccount);
    }

    @Override
    public int regUserAccount(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(userAccountDto, userAccount);
        return userAccountDao.insert(userAccount);
    }

    @Transactional
    @Override
    public String resetPassword(String user_account) {
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setUserAccount(user_account);
        String password= RandomCode.getRandomCode(6);
        userAccountDto.setPassword(password);
        this.updateUserAccount(userAccountDto);
        this.updateUserAccount(userAccountDto);
        return null;
    }

    @Override
    public int updateUserAccountByAccountName(UserAccountDto userAccountDto){
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(userAccountDto, userAccount);
        return userAccountDao.updateUserAccountByAccountName(userAccount);
    }

    public UserAccountDto findUserByName(String accountName){
        UserAccountDto userAccountDto=new UserAccountDto();
        UserAccount userAccount=userAccountDao.findUserByName(accountName);
        BeanUtils.copyProperties(userAccount, userAccountDto);
        return userAccountDto;
    }

    public UserAccountDto findUserByAccountId(String userAccountId){
        UserAccountDto userAccountDto=new UserAccountDto();
        UserAccount userAccount=userAccountDao.findUserByAccountId(userAccountId);
        BeanUtils.copyProperties(userAccount, userAccountDto);
        return userAccountDto;
    }


    private UserAccountDto changToDto(UserAccount userAccount) {
        if(userAccount == null){
            return null;
        }
        UserAccountDto userAccountDto = new UserAccountDto();
        BeanUtils.copyProperties(userAccount, userAccountDto);
        return userAccountDto;
    }
}
