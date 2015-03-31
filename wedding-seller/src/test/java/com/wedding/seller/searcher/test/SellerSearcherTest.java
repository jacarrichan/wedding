package com.wedding.seller.searcher.test;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.search.ElasticSearchHandler;
import com.wedding.common.util.JsonUtil;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.service.ISellerManageService;
import com.wedding.seller.service.ISellerSearchService;
import com.wedding.seller.test.BaseTestCase;

public class SellerSearcherTest extends BaseTestCase {

	@Autowired
	private ISellerManageService sellerService;
	
	@Autowired
	private ISellerSearchService sellerSearchService;
	
	private ElasticSearchHandler handler = new ElasticSearchHandler("127.0.0.1", 9300);	
	
	public void prepareData(){
		IndexRequestBuilder index = handler.createIndexResponse("wedding", "seller");
		SellerManageQuery query = new SellerManageQuery();
		PageQuery page = new PageQuery();
		page.setPageSize(200);
		page.setCurrPage(1);
		PageResult<SellerDto> result = sellerService.findByPageInDb(query, page);
		while(!CollectionUtils.isEmpty(result.getResults())) {
			for(SellerDto dto : result.getResults()){
				//dto.setName("刷新记录");
				String obj = JsonUtil.getJsonStr(dto);
				System.out.println();
				handler.setSource(dto.getId(), obj, index);
			}
			
			page.setTotal(result.getTotal());
			page.nextPage();
			result = sellerService.findByPageInDb(query, page);
		}
	}
	
	@Test
	public void searchTest() {
		//handler.createIndexResponse("wedding", "seller", jsondata);
		Client client = handler.getClient();		
		//QueryBuilders.prefixQuery("", "");
		QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("又");
		queryBuilder.analyzer("ik").field("name");
		BoolQueryBuilder group = QueryBuilders.boolQuery();
		group.must(queryBuilder);
		
		SearchResponse searchResponse = client.prepareSearch("wedding").setTypes("seller").setFrom(0).setSize(2)
		        .setQuery(queryBuilder)
		        .execute()
		        .actionGet();
		        SearchHits hits = searchResponse.getHits();
		        System.out.println("查询到记录数=" + hits.getTotalHits());
		        SearchHit[] searchHists = hits.getHits();
		        if(searchHists.length>0){
		            for(SearchHit hit:searchHists){
		            	String name = (String)hit.getSource().get("name");
		                Integer provinceId = (Integer)hit.getSource().get("provinceId");
		                Integer cityId =  (Integer) hit.getSource().get("cityId");
		                Integer regionId =  (Integer) hit.getSource().get("regionId");
		                System.out.println("name : " + name + "provinceId : " + provinceId + " cityId : " + cityId + " regionId : " + regionId);
		            }
		        }
		   
	}
}
