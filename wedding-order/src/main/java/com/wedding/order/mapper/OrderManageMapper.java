package com.wedding.order.mapper;

import java.util.List;

import com.wedding.order.dto.CanWithDrawOrderDto;
import org.apache.ibatis.annotations.Param;

import com.wedding.common.model.PageQuery;
import com.wedding.order.dto.OrderManageDto;
import com.wedding.order.dto.OrderManageQuery;

public interface OrderManageMapper {

	List<OrderManageDto> findByPage(@Param("query")OrderManageQuery query, @Param("page")PageQuery page);

	long count(@Param("query")OrderManageQuery query);

    List<CanWithDrawOrderDto>findByUserAndSeller(@Param("userId")String userId, @Param("page")PageQuery page);
}
