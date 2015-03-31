package com.wedding.tools.service.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.wedding.common.model.ListResult;
import com.wedding.common.redis.WdRedisDao;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tool.service.IAreaQueryService;
import com.wedding.tools.test.BaseTestCase;

public class AreaQueryServiceTest extends BaseTestCase {

	private static final String AREA_LIST_KEY = "tool:areaDto:parentId:1:forlist";

	@Autowired
	private IAreaQueryService areaQueryServcie;
	
	@Autowired
	private WdRedisDao<AreaDto> redisDao;
	
	@Test
	public void findByParentId(){
		ListResult<AreaDto> result = areaQueryServcie.findByParentId(1);
		Assert.assertTrue(!CollectionUtils.isEmpty(result.getResults()));
		for(AreaDto area : result.getResults()){
			System.out.println(area);
		}
		List<String> keys = new ArrayList<String>();
		keys.add(AREA_LIST_KEY);
		
		Assert.assertTrue(redisDao.hasKey(AREA_LIST_KEY));
		areaQueryServcie.deleteAllInRedis();
		Assert.assertTrue(!redisDao.hasKey(AREA_LIST_KEY));
	}
}
