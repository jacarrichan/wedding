package com.wedding.tools.service.impl;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.tool.dto.ToolsWeddingGovDto;
import com.wedding.tool.service.IToolsWeddingGovService;
import com.wedding.tools.dao.ToolsWeddingGovDao;
import com.wedding.tools.pojo.ToolsWeddingGov;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Service
public class ToolsWeddingGovServiceImpl implements IToolsWeddingGovService {

    @Autowired
    private ToolsWeddingGovDao toolsWeddingGovDao;


    @Override
    public PageResult<ToolsWeddingGovDto> findByCityAndProvince(ToolsWeddingGovDto toolsWeddingGovDto,PageQuery pageQuery) {
        ToolsWeddingGov toolsWeddingGov=changToPojo(toolsWeddingGovDto);
        List<ToolsWeddingGov> listToolsWeddingGov=toolsWeddingGovDao.findByCityAndProvince(toolsWeddingGov,pageQuery);
        List<ToolsWeddingGovDto> listToolsWeddingGovDto=new ArrayList<ToolsWeddingGovDto>();
        for(ToolsWeddingGov resultToolsWeddingGov:listToolsWeddingGov){
            listToolsWeddingGovDto.add(changToDto(resultToolsWeddingGov));
        }
        return new PageResult<ToolsWeddingGovDto>(pageQuery,listToolsWeddingGovDto);
    }

    @Override
    public PageResult<ToolsWeddingGovDto> findByProvince(ToolsWeddingGovDto toolsWeddingGovDto,PageQuery pageQuery) {
        ToolsWeddingGov toolsWeddingGov=changToPojo(toolsWeddingGovDto);
        List<ToolsWeddingGov> listToolsWeddingGov=toolsWeddingGovDao.findByCityAndProvince(toolsWeddingGov,pageQuery);
        List<ToolsWeddingGovDto> listToolsWeddingGovDto=new ArrayList<ToolsWeddingGovDto>();
        for(ToolsWeddingGov resultToolsWeddingGov:listToolsWeddingGov){
            listToolsWeddingGovDto.add(changToDto(resultToolsWeddingGov));
        }
        return new PageResult<ToolsWeddingGovDto>(pageQuery,listToolsWeddingGovDto);
    }



    private ToolsWeddingGovDto changToDto(ToolsWeddingGov toolsWeddingGov) {
        if(toolsWeddingGov == null){
            return null;
        }
        ToolsWeddingGovDto toolsWeddingGovDto = new ToolsWeddingGovDto();
        BeanUtils.copyProperties(toolsWeddingGov, toolsWeddingGovDto);
        return toolsWeddingGovDto;
    }

    private ToolsWeddingGov changToPojo(ToolsWeddingGovDto toolsWeddingGovDto) {
        if(toolsWeddingGovDto == null){
            return null;
        }
        ToolsWeddingGov toolsWeddingGov = new ToolsWeddingGov();
        BeanUtils.copyProperties(toolsWeddingGovDto, toolsWeddingGov);
        return toolsWeddingGov;
    }
}
