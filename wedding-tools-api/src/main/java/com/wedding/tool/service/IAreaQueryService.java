package com.wedding.tool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.tool.dto.AreaDto;

@Service
public interface IAreaQueryService {

	AreaDto findById(Integer id);
	
	ListResult<AreaDto> findByParentId(Integer parentId);

	long countAll();

	PageResult<AreaDto> findAllByPage(PageQuery page);
	
	void deleteAllInRedis();
	
	List<Integer> findAllParentId();
}
