package com.wedding.admin.controller.common;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.model.ListResult;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tool.service.IAreaQueryService;

/**
 * 提供地区数据combo类数据
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/area")
public class AreaController {
	
	@Autowired
	private IAreaQueryService areaQueryService;

	@ResponseBody
	@RequestMapping(value="/find.do")
	public ListResult<AreaDto> find(@Param("parentId")Integer parentId, @Param("level")Integer level) {
		if(level == 1 && parentId == null){
			parentId = 1;
		}
		if(parentId == null) {
			return new ListResult<AreaDto>(new ArrayList<AreaDto>());
		}
		return areaQueryService.findByParentId(parentId);
	}
}
