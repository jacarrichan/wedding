package com.wedding.home.controller;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.tool.dto.ToolsGoodDayDto;
import com.wedding.tool.dto.ToolsNoteDto;
import com.wedding.tool.dto.ToolsWeddingGovDto;
import com.wedding.tool.service.IToolsGoodDayService;
import com.wedding.tool.service.IToolsNoteService;
import com.wedding.tool.service.IToolsWeddingGovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Tank on 14-10-3.
 */
@Controller
@RequestMapping("/weddingTools")
public class WeedingToolsController {
    private final String SEARCH_TYPE="city";
    private final String NOTE_TYPE="flow";

    @Autowired
    private IToolsWeddingGovService iToolsWeddingGovService;

    @Autowired
    private IToolsNoteService iToolsNoteService;

    @Autowired
    private IToolsGoodDayService iToolsGoodDayService;

    /**
     * 查询结婚登记处
     * @param pageQuery             分页查询
     * @param searchType            查询类型 city/province
     * @param toolsWeddingGovDto    结婚民政局对象
     * @return
     */
    @RequestMapping(value = "/weddingGov.do")
    @ResponseBody
    public PageResult<ToolsWeddingGovDto> searchWeddingGov(PageQuery pageQuery,String searchType,ToolsWeddingGovDto toolsWeddingGovDto){
        if (SEARCH_TYPE.equals(searchType)) {
            return iToolsWeddingGovService.findByCityAndProvince(toolsWeddingGovDto,pageQuery);
        }
        return  iToolsWeddingGovService.findByProvince(toolsWeddingGovDto,pageQuery);
    }

    /**
     * 结婚备忘录查询
     * @param noteType 备忘录类型
     * @return
     */
    @RequestMapping(value = "/note.do")
    @ResponseBody
    public List<ToolsNoteDto> searchNote(String noteType){
        if(NOTE_TYPE.equals(noteType)){
            return iToolsNoteService.getAllWeddingFlow();
        }
        return iToolsNoteService.getAllWeddingImprove();
    }

    @RequestMapping(value = "/searchMonth.do")
    @ResponseBody
    public List<ToolsGoodDayDto> searchMonth(String startDay,String endDay){
       return iToolsGoodDayService.findToolsGoodDayBetweenRiqi(startDay,endDay);
    }

    @RequestMapping(value = "/searchDay.do")
    @ResponseBody
    public ToolsGoodDayDto searchDay(String day){
       return iToolsGoodDayService.findToolsGoodDayByRiqi(day);
    }

}
