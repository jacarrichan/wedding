package com.wedding.user.service.impl;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.user.constants.RightsCenterInternalStatusEnum;
import com.wedding.user.dao.RightsCenterDao;
import com.wedding.user.dto.RightsCenterDto;
import com.wedding.user.pojo.RightsCenter;
import com.wedding.user.service.RightsCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 14-10-5.
 */
@Service
public class RightsCenterServiceImpl implements RightsCenterService {

    @Autowired
    private RightsCenterDao rightsCenterDao;

    @Override
    public void save(RightsCenterDto rightsCenterDto) {
        RightsCenter rightsCenter = BeanUtils.createBeanByTarget(rightsCenterDto,RightsCenter.class);
        this.rightsCenterDao.insert(rightsCenter);
    }

    @Override
    public PageResult<RightsCenterDto> searchRightsCenterAll(String userAccountId, PageQuery pageQuery) {
        List<RightsCenter> rightsCenterList = this.rightsCenterDao.getRightsCenterByUserAccountId(userAccountId, pageQuery);
        List<RightsCenterDto> rightsCenterDtoList = new ArrayList<RightsCenterDto>();
        for(RightsCenter rightsCenter : rightsCenterList){
            RightsCenterDto rightsCenterDto = new RightsCenterDto();
            BeanUtils.copyProperties(rightsCenter,rightsCenterDto);
            rightsCenterDto.setStatusName(RightsCenterInternalStatusEnum.getRightsInternalStatusName(rightsCenterDto.getInternalStatus()));
            rightsCenterDtoList.add(rightsCenterDto);
        }
        return new PageResult<RightsCenterDto>(pageQuery,rightsCenterDtoList);
    }

    @Override
    public List<RightsCenterDto> findRightsById(String dateWeek,String dateMonth,PageQuery pageQuery,String id) {
        return rightsCenterDao.findRightsById(dateWeek,dateMonth,pageQuery,id);
    }

    @Override
    public String revoke(String id) {
        return  rightsCenterDao.Revoke(id);
    }

    @Override
    public Map<String, String> countRightsStatus(String dateWeek, String dateMonth, String id) {

        return rightsCenterDao.countRightsStatus(dateWeek,dateMonth,id);
    }
}
