package com.wedding.seller.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.Result;
import com.wedding.seller.dao.search.ShopSearchDao;
import com.wedding.seller.pojo.search.ShopSearch;

@Service
public class ShopSearchServiceImpl implements IShopSearchService {

	@Autowired
	private ShopSearchDao shopSearchDao;
	
	@Override
	public ListResult<Result<String>> findNameLike(String name) {
		List<Result<String>> list = new ArrayList<>();
		PageQuery page = new PageQuery();
		page.setCurrPage(1);
		page.setPageSize(10);
		List<ShopSearch> results = shopSearchDao.findByNameLike(name, page);
		for(ShopSearch shop : results) {
			list.add(new Result<String>(shop.getName()));
		}
		return new ListResult<Result<String>>(list);
	}

}
