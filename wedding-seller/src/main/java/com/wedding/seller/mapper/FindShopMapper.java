package com.wedding.seller.mapper;

import com.wedding.seller.dto.BranchMapperDto;
import com.wedding.seller.dto.ShopMappersDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FindShopMapper {

    ShopMappersDto findShopByUser(@Param("userId") String UserId);
    Map<Object,Object> findAddress(@Param("addId") String addId);
    List<BranchMapperDto> findBranchByParent(@Param("userId") String UserId);
}
