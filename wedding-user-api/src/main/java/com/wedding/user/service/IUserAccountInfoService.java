package com.wedding.user.service;

import com.wedding.user.dto.UserAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chuweifeng on 14-9-14.
 */
@Service
public interface IUserAccountInfoService {

    /**
     * 登录验证
     * @param loginName             用户名
     * @param loginPassword         密码
     * @return                      用户信息
     * **/
    public UserAccountDto checkUser(String loginName, String loginPassword);

    /**
     * 更新用户信息
     * @param userAccountDto        用户信息
     */
    public int updateUserAccount(UserAccountDto userAccountDto);

    /**
     * 快速注册用户
     * @param userAccountDto        用户信息
     */
    public int regUserAccount(UserAccountDto userAccountDto);

    /**
     * 重置密码
     * @param user_account          用户名
     * @return                      重新生成的随机密码
     */
    public String resetPassword(String user_account);

    /**
     * 根据用户名更新用户信息
     * @param userAccountDto        用户信息
     * @return
     */
    public int updateUserAccountByAccountName(UserAccountDto userAccountDto);

    /**
     * 根据用户名查询用户信息
     * @param accountName           用户信息
     * @return
     */
    public UserAccountDto findUserByName(String accountName);

    /**
     * 根据用户名查询用户信息
     * @param userAccountId           用户信息
     * @return
     */
    public UserAccountDto findUserByAccountId(String userAccountId);
}
