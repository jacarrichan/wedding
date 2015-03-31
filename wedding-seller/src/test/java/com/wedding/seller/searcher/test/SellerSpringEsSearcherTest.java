package com.wedding.seller.searcher.test;

import static org.elasticsearch.index.query.QueryBuilders.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.util.CollectionUtils;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.pojo.search.SellerSearch;
import com.wedding.seller.repository.SellerRepository;
import com.wedding.seller.service.ISellerManageService;
import com.wedding.seller.test.BaseTestCase;

public class SellerSpringEsSearcherTest extends BaseTestCase {
	
	protected static final Log logger = LogFactory.getLog(SellerSpringEsSearcherTest.class);
	
	@Autowired
	private ElasticsearchTemplate template;
	
	@Autowired
	private SellerRepository repository;
	
	@Autowired
	private ISellerManageService sellerService;
	
	@Test
	public void prepareData(){
		template.createIndex(SellerDto.class);
		SellerManageQuery query = new SellerManageQuery();
		PageQuery page = new PageQuery();
		page.setPageSize(200);
		page.setCurrPage(1);
		PageResult<SellerDto> result = sellerService.findByPageInDb(query, page);
		while(!CollectionUtils.isEmpty(result.getResults())) {
			for(SellerDto dto : result.getResults()){
				//dto.setName("刷新记录");
				SellerSearch search = BeanUtils.createBeanByTarget(dto, SellerSearch.class);
				System.out.println(search);
				repository.save(search);
			}
			
			page.setTotal(result.getTotal());
			page.nextPage();
			result = sellerService.findByPageInDb(query, page);
		}
	}
		
	public void searchData(){
		
		BoolQueryBuilder builder = boolQuery();
		builder.must(termQuery("provinceId", 530000))
				.must(termQuery("cityId", 532900));

		//page is start from one
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(builder).withPageable(new PageRequest(1,3)).build();
			
		Page<SellerDto> page  = template.queryForPage(searchQuery, SellerDto.class);
		System.out.println("total : " + page.getTotalElements());
		for(SellerDto dto : page.getContent()){
			System.out.println(dto);
		}
	}
	
	public void testFindByNameStartingWith(){
		Page<SellerSearch> retuslts = repository.findByNameStartingWith("又省*心", new PageRequest(0, 5));
		Assert.assertTrue(!CollectionUtils.isEmpty(retuslts.getContent()));
		
		for(SellerSearch result : retuslts.getContent()){
			System.out.println(result);
		}
	}
	
}
