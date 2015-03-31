package com.wedding.user.service;

import com.wedding.user.dto.UsersDto;
import com.wedding.user.dto.UsersSiteDto;
import org.springframework.stereotype.Service;

/**
 * Created by chuweifeng on 14-9-15.
 */

@Service
public interface IUsersSiteService {
     /**
      * 保存用户的基本信息
      * **/
    public int insertUsersSite(UsersSiteDto usersSiteDto);

    /**
     * 修改用户网站浏览数基本信息
     * **/
    public int updateUsersSite(UsersSiteDto usersSiteDto);

    /**
     *查询该用户是否保存过信息
     * **/
    public UsersSiteDto selectUsersSiteById(String siteId);


}
