package com.wedding.user.mapper;


import com.wedding.user.pojo.UserEvaluation;

import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public interface UserEvaluationMapper {
    List<UserEvaluation> queryEvaByUserId(String UserId);
}
