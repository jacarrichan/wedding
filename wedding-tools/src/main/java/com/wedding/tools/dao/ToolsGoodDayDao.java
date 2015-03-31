package com.wedding.tools.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.tools.mapper.ToolsGoodDayMapper;
import com.wedding.tools.pojo.ToolsGoodDay;
import com.wedding.tools.pojo.ToolsGoodDayExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Repository
public class ToolsGoodDayDao extends MyBatisBaseDao<ToolsGoodDay> {

    @Getter
    @Autowired
    private ToolsGoodDayMapper mapper;

    public ToolsGoodDay findToolsGoodDayByDay(String date){
        ToolsGoodDayExample example = new ToolsGoodDayExample();
        ToolsGoodDayExample.Criteria criteria = example.createCriteria();
        criteria.andRiqiEqualTo(date);
        List<ToolsGoodDay> results = mapper.selectByExample(example);

        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

    public List<ToolsGoodDay> findToolsGoodDayBetweenRiqi(String startDay,String endDay){
        ToolsGoodDayExample example = new ToolsGoodDayExample();
        ToolsGoodDayExample.Criteria criteria = example.createCriteria();
        criteria.andRiqiBetween(startDay,endDay);
        List<ToolsGoodDay> results = mapper.selectByExample(example);

        return CollectionUtils.isEmpty(results) ? null : results;
    }

}
