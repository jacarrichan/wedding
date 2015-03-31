package com.wedding.seller.dao.search;

import static org.elasticsearch.index.query.QueryBuilders.*;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.PageQuery;
import com.wedding.common.util.StringUtils;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.pojo.search.SellerSearch;
import com.wedding.seller.repository.SellerRepository;

@Repository
public class SellerSearchDao {
	
	protected static final Log logger = LogFactory.getLog(SellerSearchDao.class);

	@Autowired
	private SellerRepository repository;
	
	@Autowired
	private ElasticsearchTemplate template;
	
	public List<SellerSearch> findByPage(SellerManageQuery query, PageQuery page) {
		try{
			BoolQueryBuilder builder = boolQuery();
			
			if(StringUtils.isNotEmpty(query.getName())){	
//				QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(query.getName());	
//				queryBuilder.field("name").analyzer("ik");
				builder.must(queryString("*" + query.getName() + "*").field("name"));
			
			}
			if(query.getSellerType() != null){
				builder.must(termQuery("type", query.getSellerType()));
			}
			if(query.getInternalStatus() != null){
				builder.must(termQuery("internalStatus", query.getInternalStatus()));
			}
			if(query.getProvince() != null){
				builder.must(termQuery("provinceId", query.getProvince()));
			}
			if(query.getCity() != null){
				builder.must(termQuery("cityId", query.getCity()));
			}
			if(query.getDistricts() != null){
				builder.must(termQuery("regionId", query.getDistricts()));
			}
			logger.info("query --- " + builder.toString());
			//page is start from one
			SearchQuery searchQuery = new NativeSearchQueryBuilder()
					.withQuery(builder).withPageable(new PageRequest(page.getCurrPage() - 1, page.getPageSize())).build();
			
			Page<SellerSearch> resutls  = template.queryForPage(searchQuery, SellerSearch.class);
			page.setTotal(resutls.getTotalElements());
			return resutls.getContent();
		} catch(Exception e) { 
			throw new SystemException(e);
		}
	}
	
	public List<SellerSearch> findByNameLike(String name, PageQuery page) {
		Page<SellerSearch> resutls = repository.findByNameContaining(name, new PageRequest(page.getCurrPage() - 1, page.getPageSize()));
		page.setTotal(resutls.getTotalElements());
		return resutls.getContent();
	}
	
	public List<SellerSearch> findByNameStartingWith(String name, PageQuery page) {
		Page<SellerSearch> resutls = repository.findByNameStartingWith(name, new PageRequest(page.getCurrPage() - 1, page.getPageSize()));
		page.setTotal(resutls.getTotalElements());
		return resutls.getContent();
	}
	
	public void save(SellerSearch sellerManageDto){
		repository.save(sellerManageDto);
	}
	
	public void remove(String sellerId) {
		repository.delete(sellerId);
	}

}
