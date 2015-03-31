package com.wedding.user.service;

import com.wedding.user.dto.UserEvaluationDto;

import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public interface UserEvaluationService {
    public List<UserEvaluationDto> queryEvaByUserId(String userId);
}
