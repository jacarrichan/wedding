package com.wedding.user.service.impl;

import com.wedding.common.util.BeanUtils;
import com.wedding.user.dao.UserEvaluateDao;
import com.wedding.user.dto.UserEvaluateDto;
import com.wedding.user.pojo.UserEvaluate;
import com.wedding.user.service.UserEvaluateService;
import com.wedding.user.service.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Peter on 14-10-5.
 */
@Service
public class UserEvaluateServiceImpl implements UserEvaluateService {

    @Autowired
    private UserEvaluateDao userEvaluateDao;

    @Override
    public void save(UserEvaluateDto userEvaluateDto) {
        UserEvaluate userEvaluate = BeanUtils.createBeanByTarget(userEvaluateDto,UserEvaluate.class);
        this.userEvaluateDao.insert(userEvaluate);
    }
}
