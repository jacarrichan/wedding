package com.wedding.user.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.mapper.UserEvaluateMapper;
import com.wedding.user.pojo.UserEvaluate;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 14-10-5.
 */
@Repository
public class UserEvaluateDao extends MyBatisBaseDao<UserEvaluate> {

    @Autowired
    @Getter
    private UserEvaluateMapper mapper;
}
