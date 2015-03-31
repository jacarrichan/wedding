package com.wedding.user.service.impl;

import com.wedding.common.util.BeanUtils;
import com.wedding.user.dao.UserFavoriteDao;
import com.wedding.user.dto.UserFavoriteDto;
import com.wedding.user.pojo.UserFavorite;
import com.wedding.user.service.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Peter on 14-10-4.
 */
@Service
public class UserFavoriteServiceImpl implements UserFavoriteService {

    @Autowired
    private UserFavoriteDao userFavoriteDao;

    @Override
    public void save(UserFavoriteDto userFavoriteDto) {
        UserFavorite userFavorite = BeanUtils.createBeanByTarget(userFavoriteDto, UserFavorite.class);
        this.userFavoriteDao.insert(userFavorite);
    }

    @Override
    public void delete(String id) {
        this.userFavoriteDao.deleteByPrimaryKey(id);
    }
}
