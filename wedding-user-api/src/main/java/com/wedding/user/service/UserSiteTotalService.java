package com.wedding.user.service;

import com.wedding.user.dto.UserSiteTotalDto;
import com.wedding.user.dto.UsersDto;
import org.springframework.stereotype.Service;

/**
 * Created by chuweifeng on 14-10-8.
 */

@Service
public interface UserSiteTotalService {
    /**
     * 统计信息
     * **/
    public int insertSiteTotal(UserSiteTotalDto userSiteTotalDto);
}
