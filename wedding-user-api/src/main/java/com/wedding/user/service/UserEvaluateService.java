package com.wedding.user.service;

import com.wedding.user.dto.UserEvaluateDto;

/**
 * Created by Peter on 14-10-5.
 */
public interface UserEvaluateService {

    /**
     * 保存评价
     * @param userEvaluateDto
     */
    void save(UserEvaluateDto userEvaluateDto);

}
