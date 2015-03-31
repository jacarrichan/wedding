package com.wedding.seller.service;

/**
 * Created by chuweifeng on 14-9-24.
 */

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.seller.dto.AddressesDto;
import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.dto.ShopMappersDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * shop 操作接口定义
 * **/
@Service
public interface ShopService {

    public PageResult<ShopDto> queryShopByParam(PageQuery pageQuery);

    ShopDto getShopById(String id);

    ShopMappersDto getShopBySellId(String id);


    List<AddressesDto> findProvince();

    List<AddressesDto> findCity(String id);


}
