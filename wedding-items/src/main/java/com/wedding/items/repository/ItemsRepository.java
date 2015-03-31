package com.wedding.items.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wedding.items.pojo.search.ItemsSearch;

public interface ItemsRepository extends ElasticsearchRepository<ItemsSearch, String> {
	
	Page<ItemsSearch> findByItemNameContaining(String itemName, Pageable pageable);

	Page<ItemsSearch> findByItemType(Integer itemType, Pageable pageable);
	
}
