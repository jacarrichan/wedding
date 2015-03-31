package com.wedding.tool.service;


import com.wedding.tool.dto.ToolsGoodDayDto;

import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
public interface IToolsGoodDayService {

    /**
     * 查询某日黄道吉日详情
     * @param day               日期
     * @return                  黄道吉日详情
     */
    public ToolsGoodDayDto findToolsGoodDayByRiqi(String day);

    /**
     * 查询时间范围内的黄道吉日
     * @param startDay          开始日期
     * @param endDay            结束日期
     * @return                  黄道吉日详情
     */
    public List<ToolsGoodDayDto> findToolsGoodDayBetweenRiqi(String startDay,String endDay);
}
