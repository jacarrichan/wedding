package com.wedding.user.service;

import com.wedding.user.dto.UsersDto;
import org.springframework.stereotype.Service;

/**
 * Created by chuweifeng on 14-9-15.
 */

@Service
public interface IUsersService {
     /**
      * 保存用户的基本信息
      * **/
    public int insertUsers(UsersDto userDto);

    /**
     * 修改用户的基本信息
     * **/
    public int updateUsers(UsersDto usersDto);

    /**
     *查询该用户是否保存过信息
     * **/
    public UsersDto selectUsersByUserId(String userAccountId);


}
