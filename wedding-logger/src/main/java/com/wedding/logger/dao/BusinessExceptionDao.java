package com.wedding.logger.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.logger.dto.BusinessExceptionDto;
import com.wedding.logger.mapper.BusinessExceptionMapper;
import com.wedding.logger.util.SysLoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lombok.Getter;

/**
 * Created by rkzhang on 14-9-20.
 */
@Repository
public class BusinessExceptionDao extends MyBatisBaseDao<BusinessExceptionDto>{
 
    @Getter
    @Autowired
    private BusinessExceptionMapper mapper;

    public int saveException(BusinessExceptionDto exception){    	
        return mapper.insert(exception, SysLoggerUtil.getTodayBusinessExceptionLoggerTableName());
    }

   
}
