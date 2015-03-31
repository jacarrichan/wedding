package com.wedding.home.controller;

import com.wedding.domain.dto.DomainDto;
import com.wedding.domain.service.DomainService;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.service.ItemsService;
import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.dto.ShopSiteDto;
import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.service.ShopService;
import com.wedding.seller.service.ShopSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 14-10-14.
 */
@Controller
@RequestMapping(value = "/shop/site")
public class ShopSiteController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopSiteService shopSiteService;

    @Autowired
    private DomainService domainService;

    @Autowired
    private ItemsService itemsService;


    @RequestMapping(value = "/show.ftl")
    public String show(HttpServletRequest request){
        request.setAttribute("title","中国");
        return "demo";
    }
    @RequestMapping(value = "/load2.ftl")
    public String load2(HttpServletRequest request,String domain){
        DomainDto domainDto = this.domainService.getDomain(domain);
        Map<String,Object> siteContext = new HashMap<String,Object>();
        ShopSiteDto shopSiteDto = this.shopSiteService.getShopSiteByDomainId(domainDto.getId());
        if(shopSiteDto!=null){
            ShopDto shopDto =  this.shopService.getShopById(shopSiteDto.getShopId());
            List<ItemsDto> items = this.itemsService.getItemsByShopId(shopDto.getId());
            siteContext.put("shopDto",shopDto);
            siteContext.put("shopSiteDto",shopSiteDto);
            siteContext.put("items",items);
        }
        request.setAttribute("root",siteContext);
        return "index_seller";
    }
    @RequestMapping(value = "/load.ftl")
    public String load(HttpServletRequest request,String domain){
        ShopSiteIndexDto shopSiteIndexDto = this.shopSiteService.loadShopByDomain(domain);
        request.setAttribute("root",shopSiteIndexDto);
        return "index_seller";
    }

}
