package com.wedding.user.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.mapper.UserEvaluationMapper;
import com.wedding.user.pojo.UserEvaluation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public class UserEvaluationDao extends MyBatisBaseDao<UserEvaluation> {

    @Autowired
    @Getter
    private UserEvaluationMapper mapper;

    public List<UserEvaluation> queryEvaByUserId(String userId){
        return this.mapper.queryEvaByUserId(userId);
    }
}
