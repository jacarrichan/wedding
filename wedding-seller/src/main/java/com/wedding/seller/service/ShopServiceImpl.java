package com.wedding.seller.service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.seller.dao.AddressDao;
import com.wedding.seller.dao.ShopDao;
import com.wedding.seller.dto.AddressesDto;
import com.wedding.seller.dto.BranchMapperDto;
import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.dto.ShopMappersDto;
import com.wedding.seller.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuweifeng on 14-9-24.
 */
@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    public PageResult<ShopDto> queryShopByParam(PageQuery pageQuery) {
        List<Shop> resultList = shopDao.queryShopByParam(pageQuery);
        List<ShopDto> shopDtoList = new ArrayList<ShopDto>();
        for(Shop shop : resultList){
            ShopDto shopDto = new ShopDto();
            BeanUtils.copyProperties(shop, shopDto);
            shopDtoList.add(shopDto);
        }
        return new PageResult<ShopDto>(pageQuery,shopDtoList);
    }

    @Override
    public ShopDto getShopById(String id) {
        Shop shop = this.shopDao.selectByPrimaryKey(id);
        return BeanUtils.createBeanByTarget(shop,ShopDto.class);
    }

    @Override
    public ShopMappersDto getShopBySellId(String id) {
         ShopMappersDto shopMappersDto = shopDao.findShopByUserId(id);
        if(shopMappersDto!=null){
            if(shopMappersDto.getProvinceCode()!=null){
                shopMappersDto.setProvinceName(shopDao.findAddresses(shopMappersDto.getProvinceCode()).get("name").toString());
            }
            if(shopMappersDto.getCityCode()!=null){
                shopMappersDto.setCityName(shopDao.findAddresses(shopMappersDto.getCityCode()).get("name").toString());
            }
            if(shopMappersDto.getRegionCode()!=null){
                shopMappersDto.setRegionName(shopDao.findAddresses(shopMappersDto.getRegionCode()).get("name").toString());
            }
            List<BranchMapperDto> list = shopDao.findBranchByParentUser(id);
            if(list!=null){
                for(BranchMapperDto branchMapperDto : list){
                    if(branchMapperDto.getProvinceCode()!=null){
                        branchMapperDto.setProvinceName(shopDao.findAddresses(shopMappersDto.getProvinceCode()).get("name").toString());
                    }
                    if(branchMapperDto.getCityCode()!=null){
                        branchMapperDto.setCityName(shopDao.findAddresses(shopMappersDto.getCityCode()).get("name").toString());
                    }
                    if(branchMapperDto.getRegionCode()!=null){
                        branchMapperDto.setRegionName(shopDao.findAddresses(shopMappersDto.getRegionCode()).get("name").toString());
                    }
                }
            }
            shopMappersDto.setBranchList(list);

        }
        return shopMappersDto;

    }


    @Override
    public List<AddressesDto> findProvince() {
        return addressDao.findProvince();
    }

    @Override
    public List<AddressesDto> findCity(String id) {
        return addressDao.findCity(id);
    }



}
