package com.wedding.sync.handler.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedding.common.model.Result;
import com.wedding.common.util.BeanUtils;
import com.wedding.seller.dao.search.SellerSearchDao;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.pojo.search.SellerSearch;
import com.wedding.seller.service.ISellerManageService;
import com.wedding.sync.annotation.TableName;
import com.wedding.sync.handler.IDataHandler;
import com.wedding.sync.model.DataInfo;

@TableName("wd_seller")
@Service
public class SellerDataHandler implements IDataHandler {
	
	@Autowired
	private SellerSearchDao sellerSearchDao;
	
	@Autowired
	private ISellerManageService sellerService;

	@Override
	public void create(DataInfo dataInfo) {
		String sellerId = dataInfo.getColumnStringValue("id");
		Result<SellerDto> result = sellerService.findBySellerId(sellerId);
		SellerSearch search = BeanUtils.createBeanByTarget(result.getResult(), SellerSearch.class);
		sellerSearchDao.save(search);
	}

	@Override
	public void update(DataInfo dataInfo) {
		String sellerId = dataInfo.getColumnStringValue("id");
		Integer stat = dataInfo.getColumnIntegerValue("stat");
		if(stat == null || stat.intValue() == 0) {
			sellerSearchDao.remove(sellerId);
		} else {
			Result<SellerDto> result = sellerService.findBySellerId(sellerId);
			SellerSearch search = BeanUtils.createBeanByTarget(result.getResult(), SellerSearch.class);
			sellerSearchDao.save(search);
		}

	}

	@Override
	public void delete(DataInfo dataInfo) {
		String sellerId = dataInfo.getColumnStringValue("id");
		sellerSearchDao.remove(sellerId);
	}

}
