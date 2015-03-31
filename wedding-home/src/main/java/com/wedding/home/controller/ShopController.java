package com.wedding.home.controller;

/**
 * Created by chuweifeng on 14-9-23.
 */


import com.wedding.common.constants.SessionConstants;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.service.ItemsService;
import com.wedding.seller.dto.AddressesDto;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.dto.ShopMappersDto;
import com.wedding.seller.service.SellerService;
import com.wedding.seller.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 前台店铺操作 controller 层
 * **/
@Controller
@RequestMapping(value="/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private SellerService sellerService;

    /**
     * 店铺列表展示层
     * 店铺存在级别和状态
     * **/

    @RequestMapping(value = "/queryShop.do")
    @ResponseBody
    public PageResult <ShopDto> queryShop(PageQuery pageQuery){
        PageResult<ShopDto> resultList = shopService.queryShopByParam(pageQuery);
        return resultList;
    }

    /**
     * @param pageQuery
     * @param itemsDto
     * 根据当前条件筛选店铺商品信息
     * **/
    @RequestMapping(value = "/queryItem.do")
    @ResponseBody
    public PageResult<ItemsDto> queryItem(PageQuery pageQuery,ItemsDto itemsDto){
        PageResult<ItemsDto> resultList = itemsService.queryItem(itemsDto,pageQuery);
        return resultList;
    }
    /**
     * 查询当前用户的店铺信息(shopcenter页面)
     */
    @RequestMapping(value="/shopInfos.do")
    @ResponseBody
    public ShopMappersDto findShopInfo(HttpSession session){
        String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
//        String sellerId ="0013309a-d83f-43dd-b570-b2c9b4478c90";
        ShopMappersDto result =  shopService.getShopBySellId(sellerId);
        return result;

    }


    /**
     *增加分店(shopcenter页面)
     * @param session
     * @return
     */
    @RequestMapping(value="/branchCreate.do")
    @ResponseBody
    public String createBranch(HttpSession session,@RequestParam("provinceId") String provinceId,@RequestParam("cityId") String cityId,@RequestParam("regionId") String regionId,@RequestParam("address") String address){
        String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
//        String sellerId ="0013309a-d83f-43dd-b570-b2c9b4478c90";
        SellerDto regionSeller = sellerService.findParentById(sellerId);
        if(regionSeller!=null){
            regionSeller.setId(null);
            regionSeller.setProvinceCode(Integer.parseInt(provinceId));
        if(cityId!=""&&!"nulls".equals(cityId)){
            regionSeller.setCityCode(Integer.parseInt(cityId));
        }
        if(regionId!=null&&"nulls".equals(regionId)){
            regionSeller.setRegionCode(Integer.parseInt(regionId));
        }
            regionSeller.setAddress(address);
            regionSeller.setParentId(sellerId);
            sellerService.registerSeller(regionSeller);
            return "分店开设成功";
       }else{
            return "查询不到父商家";
        }

    }

    /**
     * 查询省(shopcenter页面)
     */
    @RequestMapping(value="/findProvince.do")
    @ResponseBody
    public List<AddressesDto> findProvince(){

        return shopService.findProvince();
    }

    /**
     * 查询市或者区(shopcenter页面)
     *
     */
    @RequestMapping(value = "/findCity.do")
    @ResponseBody
    public List<AddressesDto> findCity(@RequestParam("citysId")String citysId){
        return shopService.findCity(citysId);
    }

    @RequestMapping(value="/updateInfos.do")
    @ResponseBody
    public String updateShop(String jsonString,HttpSession session){

            return null;
    }




}


