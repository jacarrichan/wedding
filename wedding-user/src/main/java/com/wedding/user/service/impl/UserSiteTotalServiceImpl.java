package com.wedding.user.service.impl;

import com.wedding.user.dao.UserSiteTotalDao;
import com.wedding.user.dto.UserSiteTotalDto;
import com.wedding.user.pojo.UserSiteTotal;
import com.wedding.user.service.UserSiteTotalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chuweifeng on 14-10-8.
 */
@Service
public class UserSiteTotalServiceImpl implements UserSiteTotalService {

    @Autowired
    private UserSiteTotalDao userSiteTotalDao;

    @Override
    public int insertSiteTotal(UserSiteTotalDto userSiteTotalDto) {
        UserSiteTotal userSiteTotal = new UserSiteTotal();
        BeanUtils.copyProperties(userSiteTotalDto, userSiteTotal);
        return userSiteTotalDao.insert(userSiteTotal);
    }
}
