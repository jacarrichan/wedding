package com.wedding.seller.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.wedding.seller.pojo.search.SellerSearch;

public interface SellerRepository extends ElasticsearchRepository<SellerSearch,String> {

	Page<SellerSearch> findByNameStartingWith(String name, Pageable pageable);
	
	Page<SellerSearch> findByNameContaining(String name, Pageable pageable);
	
}
