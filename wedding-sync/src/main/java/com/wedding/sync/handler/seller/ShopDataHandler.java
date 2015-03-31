package com.wedding.sync.handler.seller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.seller.dao.SellerDao;
import com.wedding.seller.dao.search.ShopSearchDao;
import com.wedding.seller.pojo.Seller;
import com.wedding.seller.pojo.search.ShopSearch;
import com.wedding.sync.annotation.TableName;
import com.wedding.sync.handler.IDataHandler;
import com.wedding.sync.model.DataInfo;
import com.wedding.tools.cache.AreaCache;

@TableName("wd_shop")
@Service
public class ShopDataHandler implements IDataHandler {

	protected static final Log logger = LogFactory.getLog(ShopDataHandler.class);
	
	@Autowired
	private ShopSearchDao shopSearchDao;
	
	@Autowired
	private SellerDao sellerDao;
	
	@Autowired
	private AreaCache areaCache;
	
	@Override
	public void create(DataInfo dataInfo) {
		logger.info("create : " + dataInfo);
		ShopSearch shop = populateShopSearch(dataInfo);
		setAreaInfo(shop);
		shopSearchDao.save(shop);
	}

	

	@Override
	public void update(DataInfo dataInfo) {
		logger.info("update : " + dataInfo);
		Integer stat = dataInfo.getColumnIntegerValue("stat");
		if(stat == null || stat.intValue() == 0) {
			String shopId = dataInfo.getColumnStringValue("id");
			shopSearchDao.remove(shopId);
		} else {
			ShopSearch shop = populateShopSearch(dataInfo);
			setAreaInfo(shop);
			shopSearchDao.save(shop);	
		}
		
	}

	@Override
	public void delete(DataInfo dataInfo) {
		logger.info("delete : " + dataInfo);
		String shopId = dataInfo.getColumnStringValue("id");
		shopSearchDao.remove(shopId);
	}

	private ShopSearch populateShopSearch(DataInfo dataInfo) {
		ShopSearch shop = new ShopSearch();
		shop.setId(dataInfo.getColumnStringValue("id"));
		shop.setName(dataInfo.getColumnStringValue("name"));
		shop.setLogo(dataInfo.getColumnStringValue("logo"));
		shop.setSellerId(dataInfo.getColumnStringValue("seller_id"));
		shop.setActivityType(dataInfo.getColumnIntegerValue("activity_type"));
		shop.setCreateTime(dataInfo.getColumnDateValue("create_time"));
		Seller seller = sellerDao.selectByPrimaryKey(shop.getSellerId());
		if(seller != null) {
			shop.setSellerName(seller.getName());
		}
		return shop;
	}
	
	private void setAreaInfo(ShopSearch shop) {
		Seller seller = sellerDao.selectByPrimaryKey(shop.getSellerId());
		if(seller != null) {
			shop.setCityCode(seller.getCityCode());
			shop.setCityName(areaCache.findNameById(seller.getCityCode()));
			shop.setProvinceCode(seller.getProvinceCode());
			shop.setProvinceName(areaCache.findNameById(seller.getProvinceCode()));
			shop.setRegionCode(seller.getRegionCode());
			shop.setRegionName(areaCache.findNameById(seller.getRegionCode()));
		}
	}

}
