package com.wedding.seller.mapper;

import com.wedding.common.model.PageQuery;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerManageMapper {

	List<SellerDto> findByPage(@Param("query")SellerManageQuery query, @Param("page")PageQuery page);
	
	List<SellerDto> findBySellerId(String sellerId);
	
	long count(@Param("query")SellerManageQuery query);

    SellerDto findParentSeller(String ids);
	
}
