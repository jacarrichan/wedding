package com.wedding.home.controller.frontend;

import com.wedding.admin.home.cache.PageDataCache;
import com.wedding.home.dto.PageData;
import com.wedding.home.service.IHomePageConfigSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 14-11-16.
 */
@Controller
@RequestMapping(value = "/api/home")
public class IndexController {

    @Autowired
    private PageDataCache pageDataCache;

    @Autowired
    private IHomePageConfigSerivce iHomePageConfigSerivce;
    /**
     * 加载首页数据
     */
    @ResponseBody
    @RequestMapping(value = "/index.do")
    public Map<String,List<PageData>> index(){
        // 本月热销推荐
        // 聚喜推荐
        // 聚喜大促销
        // 会员推荐
        return iHomePageConfigSerivce.findAll();
    }

}
