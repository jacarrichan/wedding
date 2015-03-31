package com.wedding.order.dao;

import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.order.dto.OrderManageDto;
import com.wedding.order.dto.OrderManageQuery;
import com.wedding.order.mapper.OrderManageMapper;

@Repository
public class OrderManageDao extends MyBatisBaseDao<OrderManageDto> {

	@Autowired
	@Getter
	private OrderManageMapper mapper;
	
	public List<OrderManageDto> findByPage(OrderManageQuery query, PageQuery page) {
		return mapper.findByPage(query, page);
	}

	public long count(OrderManageQuery query) {
		Integer i = 0;
		return mapper.count(query);
	}
	
}
