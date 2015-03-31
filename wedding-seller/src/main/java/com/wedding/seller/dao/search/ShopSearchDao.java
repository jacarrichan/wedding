package com.wedding.seller.dao.search;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import com.wedding.common.model.PageQuery;
import com.wedding.seller.pojo.search.SellerSearch;
import com.wedding.seller.pojo.search.ShopSearch;
import com.wedding.seller.repository.ShopRepository;

@Repository
public class ShopSearchDao {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ElasticsearchTemplate template;
	
	public List<ShopSearch> findByNameLike(String name, PageQuery page) {
		Page<ShopSearch> resutls = shopRepository.findByNameContaining(name, new PageRequest(page.getCurrPage() - 1, page.getPageSize()));
		page.setTotal(resutls.getTotalElements());
		return resutls.getContent();
	}
	
	public void save(ShopSearch shop){
		shopRepository.save(shop);
	}
	
	public void remove(String shopId) {
		shopRepository.delete(shopId);
	}
	
	public List<ShopSearch> findByAreaId(Integer areaId, Integer activityType, Integer number) {
		//Page<ShopSearch> results = shopRepository.findByActivityTypeAndProvinceCodeOrCityCodeOrRegionCode(activityType, areaId, areaId, areaId, new PageRequest(0, number - 1));
		if(activityType == null) {
			 Page<ShopSearch> results = shopRepository.findByProvinceCodeOrCityCodeOrRegionCode(areaId, areaId, areaId, new PageRequest(0, number));
			 return results.getContent();
		}
		
		BoolQueryBuilder builder = boolQuery();
		builder.must(termQuery("activityType", activityType));
		
		BoolQueryBuilder areabuilder = boolQuery();
		areabuilder.should(termQuery("provinceCode", areaId));
		areabuilder.should(termQuery("cityCode", areaId));
		areabuilder.should(termQuery("regionCode", areaId));
		
		builder.must(areabuilder);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
		.withQuery(builder).withPageable(new PageRequest(0, number)).build();
		
		Page<ShopSearch> resutls  = template.queryForPage(searchQuery, ShopSearch.class);
		return resutls.getContent();
	}
}
