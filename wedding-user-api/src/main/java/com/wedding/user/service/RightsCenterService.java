package com.wedding.user.service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.user.dto.RightsCenterDto;

import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 14-10-5.
 */
public interface RightsCenterService {

    /**
     * 添加维权信息
     * @param rightsCenterDto
     */
    void save(RightsCenterDto rightsCenterDto);

    PageResult<RightsCenterDto> searchRightsCenterAll(String userAccountId,PageQuery pageQuery);

    List<RightsCenterDto> findRightsById(String dateWeek,String dateMonth,PageQuery pageQuery,String id);

    String revoke(String id);

    Map<String,String> countRightsStatus(String dateWeek,String dateMonth,String id);
}
