package com.wedding.user.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.mapper.UserFavoriteMapper;
import com.wedding.user.pojo.UserFavorite;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 14-10-4.
 */
@Repository
public class UserFavoriteDao extends MyBatisBaseDao<UserFavorite> {

    @Autowired
    @Getter
    private UserFavoriteMapper mapper;

}
