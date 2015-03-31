package com.wedding.seller.mapper;

import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.pojo.ShopSite;
import com.wedding.seller.pojo.ShopSiteExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopSiteIndexMapper {

    ShopSiteIndexDto loadShopSite(@Param("domain") String domain);

}