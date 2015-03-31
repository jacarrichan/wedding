package com.wedding.items.dao.search;

import static org.elasticsearch.index.query.QueryBuilders.*;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
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
import com.wedding.common.model.PageQuery;
import com.wedding.common.util.StringUtils;
import com.wedding.items.dto.ItemsSearchQuery;
import com.wedding.items.mapper.ItemsExMapper;
import com.wedding.items.pojo.search.ItemsSearch;
import com.wedding.items.repository.ItemsRepository;

@Repository
public class ItemsSearchDao {
	
	protected static final Log logger = LogFactory.getLog(ItemsSearchDao.class);

	@Autowired
	private ElasticsearchTemplate template;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Autowired
	private ItemsExMapper itemsExMapper;

	public List<ItemsSearch> search(ItemsSearchQuery query, PageQuery page) {
		BoolQueryBuilder builder = boolQuery();
		if(StringUtils.isNotEmpty(query.getSellerName())) {
			builder.must(queryString("*" + query.getSellerName() + "*").field("sellerName"));
		}
		
		if(StringUtils.isNotEmpty(query.getShopName())) {
			builder.must(queryString("*" + query.getShopName() + "*").field("shopName"));
			
		}
		
		if(StringUtils.isNotEmpty(query.getItemName())) {
			builder.must(queryString("*" + query.getItemName() + "*").field("itemName"));
		}
		
		if(query.getItemsType() != null) {
			builder.must(termQuery("itemType", query.getItemsType()));
		}
		
		logger.info("query --- " + builder.toString());
		builder.disableCoord(true);
		//page is start from one
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(builder).withPageable(new PageRequest(page.getCurrPage() - 1, page.getPageSize())).build();
		
		Page<ItemsSearch> resutls  = template.queryForPage(searchQuery, ItemsSearch.class);
		page.setTotal(resutls.getTotalElements());
		return resutls.getContent();
		
	}
	
	public List<ItemsSearch> findByItemNameLike (String itemName, PageQuery page) {
		Page<ItemsSearch> items = itemsRepository.findByItemNameContaining(itemName, new PageRequest(page.getCurrPage() - 1, page.getPageSize()));
		page.setTotal(items.getTotalElements());
		return items.getContent();
	}
	
	public ItemsSearch findInDbById(String itemId) {
		List<ItemsSearch> searchResults = itemsExMapper.findById(itemId);
		return CollectionUtils.isEmpty(searchResults) ? null : searchResults.get(0);
	}
	
	public void removeById(String itemsId) { 
		itemsRepository.delete(itemsId);
	}

	public void saveOrUpdate(ItemsSearch search) {
		itemsRepository.save(search);
	}
	
	public List<ItemsSearch> findByItemType(Integer itemType, Integer number) {
		
		Page<ItemsSearch> items = itemsRepository.findByItemType(itemType, new PageRequest(0, number));
		return items.getContent();
	}

}
