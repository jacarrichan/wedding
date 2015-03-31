package com.wedding.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;
import com.wedding.common.util.StringUtils;
import com.wedding.seller.constants.SellerInternalStatusEnum;
import com.wedding.seller.constants.SellerTypeEnum;
import com.wedding.seller.dao.SellerManageDao;
import com.wedding.seller.dto.SellerCurdDto;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.tool.service.IAreaQueryService;

@Service
public class SellerManageServiceImpl implements ISellerManageService {
	
	@Autowired
	private SellerService sellerService;

	@Autowired
	private SellerManageDao sellerManageDao;
	
	@Autowired
	private IAreaQueryService areaQueryService;

	
	@Override
	public PageResult<SellerDto> findByPageInDb(SellerManageQuery query, PageQuery page) {
		process(query);
		List<SellerDto> results = sellerManageDao.findByPageInDB(query, page);
		for(SellerDto record : results){
			record.setTypeName(SellerTypeEnum.getSellerTypeName(record.getType().intValue()));
			record.setInternalStatusName(SellerInternalStatusEnum.getSellerInternalStatusName(record.getInternalStatus().intValue()));
			record.setFullAddress(sellerService.populateFullAddress(record));
		}
		long total = sellerManageDao.count(query);
		page.setTotal(total);
		return new PageResult<SellerDto>(page, results);
	}
	
	@Override
	public Result<SellerDto> findBySellerId(String sellerId) {
		SellerDto result = sellerManageDao.findBySellerId(sellerId);
		if(result != null) {
			result.setTypeName(SellerTypeEnum.getSellerTypeName(result.getType().intValue()));
			result.setInternalStatusName(SellerInternalStatusEnum.getSellerInternalStatusName(result.getInternalStatus().intValue()));
			result.setFullAddress(sellerService.populateFullAddress(result));
		}
		return new Result<SellerDto>(result);
	}

	private void process(SellerManageQuery query) {
		String name = StringUtils.isNotEmpty(query.getName()) ? "%" + query.getName().trim() + "%" : null;
		query.setName(name);
		
	}

	@Override
	public RequestResult saveOrUpdate(SellerCurdDto seller) {
		System.out.println(seller);
		if(StringUtils.isEmpty(seller.getId())){
			return sellerService.create(seller);
		}else{
			return sellerService.update(seller);
		}
	}

}
