package com.wedding.tools.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.tool.dto.AreaDto;
import com.wedding.tools.test.BaseTestCase;

public class AreaCacheTest extends BaseTestCase {

	@Autowired
	private AreaCache areaCache;
	
	@Test
	public void areaCacheTest() {
		AreaDto area = areaCache.get(110100);
		area = areaCache.get(110100);
		System.out.println(area);
	}
}
