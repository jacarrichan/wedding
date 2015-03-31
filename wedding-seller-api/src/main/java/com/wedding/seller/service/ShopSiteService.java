package com.wedding.seller.service;

import com.wedding.seller.dto.ShopSiteDto;
import com.wedding.seller.dto.ShopSiteIndexDto;

/**
 * Created by Peter on 14-10-19.
 */
public interface ShopSiteService {

    /**
     * 获取店铺信息
     * @param domainId
     * @return
     */
    public ShopSiteDto getShopSiteByDomainId(String domainId);

    /**
     * 根据域名信息加载网站数据
     * @param domain
     * @return
     */
    public ShopSiteIndexDto loadShopByDomain(String domain);


}
