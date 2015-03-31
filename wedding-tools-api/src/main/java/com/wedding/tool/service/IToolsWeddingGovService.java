package com.wedding.tool.service;


import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.tool.dto.ToolsWeddingGovDto;

/**
 * Created by Tank on 14-9-30.
 */
public interface IToolsWeddingGovService {

    /**
     * 根据toolsWeddingGov的省、市信息，定位查询民政局信息
     * @param toolsWeddingGovDto
     * @return
     */
    public PageResult<ToolsWeddingGovDto> findByCityAndProvince(ToolsWeddingGovDto toolsWeddingGovDto,PageQuery pageQuery);


    /**
     * 根据toolsWeddingGov的省，定位查询民政局信息
     * @param toolsWeddingGovDto
     * @return
     */
    public PageResult<ToolsWeddingGovDto> findByProvince(ToolsWeddingGovDto toolsWeddingGovDto,PageQuery pageQuery);

}
