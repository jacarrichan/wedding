package com.wedding.order.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.AppointQuery;
import com.wedding.order.mapper.AppointExMapper;
import com.wedding.order.mapper.AppointMapper;
import com.wedding.order.pojo.Appoint;
import com.wedding.order.pojo.AppointExample;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-9-19.
 */
@Repository
public class AppointDao extends MyBatisBaseDao<Appoint> {

    @Autowired
    @Getter
    private AppointMapper mapper;
    
    @Autowired
    private AppointExMapper exMapper;

    public void updateStatus(Appoint appoint){
        AppointExample example = new AppointExample();
        AppointExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(appoint.getId());
        this.mapper.updateByExample(appoint,example);
    }

    public Appoint getAppointById(String id){
        return this.mapper.selectByPrimaryKey(id);
    }

    public List<Appoint> getAppointsBySeller(String sellerId,PageQuery pageQuery){
        AppointExample example = new AppointExample();
        AppointExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }

    public List<Appoint> getAppointByUser(String userId,PageQuery pageQuery){
        AppointExample example = new AppointExample();
        AppointExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }

	public List<AppointDto> findByPage(AppointQuery query, PageQuery pageQuery) {
	     return exMapper.findByPage(query, pageQuery);
	}

	public long count(AppointQuery query) {
		return exMapper.count(query);
	}

}
