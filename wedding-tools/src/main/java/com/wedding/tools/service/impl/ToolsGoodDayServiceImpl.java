package com.wedding.tools.service.impl;

import com.wedding.tool.dto.ToolsGoodDayDto;
import com.wedding.tool.service.IToolsGoodDayService;
import com.wedding.tools.dao.ToolsGoodDayDao;
import com.wedding.tools.pojo.ToolsGoodDay;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Service
public class ToolsGoodDayServiceImpl implements IToolsGoodDayService {

    @Autowired
    private ToolsGoodDayDao toolsGoodDayDao;

    @Override
    public ToolsGoodDayDto findToolsGoodDayByRiqi(String day) {
        ToolsGoodDay toolsGoodDay=toolsGoodDayDao.findToolsGoodDayByDay(day);
        return changToDto(toolsGoodDay);
    }

    @Override
    public List<ToolsGoodDayDto> findToolsGoodDayBetweenRiqi(String startDay, String endDay) {
        List<ToolsGoodDay> toolsGoodDayList=toolsGoodDayDao.findToolsGoodDayBetweenRiqi(startDay,endDay);
        List<ToolsGoodDayDto> toolsGoodDayDtoList=new ArrayList<ToolsGoodDayDto>();
        for(ToolsGoodDay toolsGoodDay:toolsGoodDayList){
            toolsGoodDayDtoList.add(changToDto(toolsGoodDay));
        }
        return toolsGoodDayDtoList;
    }

    private ToolsGoodDayDto changToDto(ToolsGoodDay toolsGoodDay) {
        if(toolsGoodDay == null){
            return null;
        }
        ToolsGoodDayDto toolsGoodDayDto = new ToolsGoodDayDto();
        BeanUtils.copyProperties(toolsGoodDay, toolsGoodDayDto);
        return toolsGoodDayDto;
    }
}
