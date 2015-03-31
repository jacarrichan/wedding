package com.wedding.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.Result;
import com.wedding.common.util.BeanUtils;
import com.wedding.seller.constants.SellerInternalStatusEnum;
import com.wedding.seller.constants.SellerTypeEnum;
import com.wedding.seller.dao.search.SellerSearchDao;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.pojo.search.SellerSearch;

@Service
public class SellerSearchServiceImpl implements ISellerSearchService {

	@Autowired
	private SellerSearchDao sellerSearchDao;
	
	@Override
	public PageResult<SellerDto> findByPage(SellerManageQuery query, PageQuery page) {		
		List<SellerSearch> searchResults = sellerSearchDao.findByPage(query, page);
		List<SellerDto> results = BeanUtils.createBeanListByTarget(searchResults, SellerDto.class);
		for(SellerDto record : results){
			record.setTypeName(SellerTypeEnum.getSellerTypeName(record.getType().intValue()));
			record.setInternalStatusName(SellerInternalStatusEnum.getSellerInternalStatusName(record.getInternalStatus().intValue()));
			//record.setFullAddress(populateFullAddress(record));
		}
		//long total = sellerManageDao.count(query);
		//page.setTotal(total);
		return new PageResult<SellerDto>(page, results);
	}
	
	@Override
	public PageResult<SellerDto> findByNameStartingWith(String name, PageQuery page) {
		List<SellerSearch> searchResults = sellerSearchDao.findByNameStartingWith(name, page);
		List<SellerDto> results = BeanUtils.createBeanListByTarget(searchResults, SellerDto.class);
		return new PageResult<SellerDto>(page, results) ;
	}

	@Override
	public ListResult<Result<String>> findNameLike(String name) {
		List<Result<String>> list = new ArrayList<>();
		PageQuery page = new PageQuery();
		page.setCurrPage(1);
		page.setPageSize(10);
		List<SellerSearch> results = sellerSearchDao.findByNameLike(name, page);
		for(SellerSearch seller : results) {
			list.add(new Result<String>(seller.getName()));
		}
		return new ListResult<Result<String>>(list);
	}

}
