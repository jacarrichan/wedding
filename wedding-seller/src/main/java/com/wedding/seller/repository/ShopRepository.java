package com.wedding.seller.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.wedding.seller.pojo.search.ShopSearch;

public interface ShopRepository extends ElasticsearchRepository<ShopSearch,String> {
	
	Page<ShopSearch> findByNameContaining(String name, Pageable pageable);

	Page<ShopSearch> findByProvinceCodeOrCityCodeOrRegionCode(Integer provinceCode, Integer cityCode, Integer regionCode, Pageable pageable);
	
}
