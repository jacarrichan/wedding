package com.wedding.user.service.impl;

import com.wedding.common.util.BeanUtils;
import com.wedding.user.dao.UserEvaluationDao;
import com.wedding.user.dto.UserEvaluationDto;
import com.wedding.user.pojo.UserEvaluation;
import com.wedding.user.service.UserEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public class UserEvaluationServiceImpl implements UserEvaluationService {
    @Autowired
    private UserEvaluationDao userEvaluationDao;

    @Override
    public List<UserEvaluationDto> queryEvaByUserId(String shopId) {
        List<UserEvaluation> resultList = userEvaluationDao.queryEvaByUserId(shopId);
        List<UserEvaluationDto> UserEvaluationDtoList =new ArrayList<UserEvaluationDto>();
        for(UserEvaluation userEvaluation:resultList){
            UserEvaluationDto userEvaluationDto = new UserEvaluationDto();
            BeanUtils.copyProperties(userEvaluation,userEvaluationDto);
            UserEvaluationDtoList.add(userEvaluationDto);
        }
        return UserEvaluationDtoList;
    }
}
