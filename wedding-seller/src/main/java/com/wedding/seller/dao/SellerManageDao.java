package com.wedding.seller.dao;

import com.wedding.common.model.PageQuery;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.mapper.SellerManageMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerManageDao {
	
	protected static final Log logger = LogFactory.getLog(SellerManageDao.class);
	
	@Autowired
	private SellerManageMapper mapper;
			
	public List<SellerDto> findByPageInDB(SellerManageQuery query, PageQuery page) {
		return mapper.findByPage(query, page);
	}

	public SellerDto findBySellerId(String sellerId) {
		List<SellerDto> sellers = mapper.findBySellerId(sellerId);
		return CollectionUtils.isEmpty(sellers) ? null : sellers.get(0);
	}
	
	public long count(SellerManageQuery query) {
		return mapper.count(query);
	}

    public SellerDto findParentSellerById(String sellerId){
        return mapper.findParentSeller(sellerId);
    }
	
}
