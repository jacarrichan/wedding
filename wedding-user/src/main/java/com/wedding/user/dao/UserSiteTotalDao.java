package com.wedding.user.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.mapper.UserEvaluateMapper;
import com.wedding.user.mapper.UserSiteTotalMapper;
import com.wedding.user.pojo.UserFavorite;
import com.wedding.user.pojo.UserSiteTotal;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by chuweifeng on 14-10-8.
 */

@Repository
public class UserSiteTotalDao extends MyBatisBaseDao<UserSiteTotal> {

    @Autowired
    @Getter
    private UserSiteTotalMapper mapper;

}
