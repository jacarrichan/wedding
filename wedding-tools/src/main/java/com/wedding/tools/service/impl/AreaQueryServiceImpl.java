package com.wedding.tools.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.redis.RedisKeyPrefix;
import com.wedding.common.redis.RedisKeyResolver;
import com.wedding.common.redis.WdRedisDao;
import com.wedding.common.util.BeanUtils;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tool.service.IAreaQueryService;
import com.wedding.tools.cache.AreaCache;
import com.wedding.tools.dao.AddressesDao;
import com.wedding.tools.pojo.Addresses;

/**
 * 地域信息查询
 * @author rkzhang
 */
@Service
public class AreaQueryServiceImpl implements IAreaQueryService {

	@Autowired
	private AddressesDao addressesDao;
	
	@Autowired
	private WdRedisDao<AreaDto> redisDao;
	
	@Autowired
	private RedisKeyResolver<AreaDto> keyResolver;
	
	@Autowired
	private AreaCache areaCache;
	
	@Override
	public ListResult<AreaDto> findByParentId(Integer parentId) {
		List<AreaDto> areaList = redisDao.getList(parentId.toString(), AreaDto.class);
		if(!CollectionUtils.isEmpty(areaList)){
			return new ListResult<AreaDto>(areaList);
		}
		
		List<Addresses> addresses = addressesDao.findByPerentId(parentId);
		if(CollectionUtils.isEmpty(addresses)){
			return new ListResult<AreaDto>(areaList);
		}
		
		areaList = BeanUtils.createBeanListByTarget(addresses, AreaDto.class); 
		for(AreaDto area : areaList){
			redisDao.setToList(area);
		}
		
		return new ListResult<AreaDto>(areaList);
	}

	@Override
	public long countAll() {
		return addressesDao.countAll();
	}

	@Override
	public PageResult<AreaDto> findAllByPage(PageQuery page) {
		List<Addresses> accounts = addressesDao.findAllByPage(page);
		List<AreaDto> areaResults = BeanUtils.createBeanListByTarget(accounts, AreaDto.class);
		return new PageResult<AreaDto>(page, areaResults);
	}
	
	public void deleteAllInRedis(){
		List<Integer> parentIds = addressesDao.findAllParentId();
		if(CollectionUtils.isEmpty(parentIds)){
			return;
		}
		
		List<String> redisKeys = this.getAllRedisKey(parentIds);
		if(CollectionUtils.isEmpty(redisKeys)){
			return;
		}
		
		redisDao.delete(redisKeys);
	}
	
	public List<Integer> findAllParentId(){
		return addressesDao.findAllParentId();
	}
	
	private List<String> getAllRedisKey(List<Integer> parentIds){
		RedisKeyPrefix prefix = keyResolver.getRedisKeyPrefix(AreaDto.class);
		List<String> redisKeys = new ArrayList<>();
		for(Integer id : parentIds){
			String key = keyResolver.paseKeyForList(prefix, id.toString());
			redisKeys.add(key);
		}
		return redisKeys;
	}

	@Override
	public AreaDto findById(Integer id) {
		return areaCache.get(id);
	}

}
