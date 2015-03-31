package com.wedding.seller.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.mapper.ShopSiteIndexMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 14-10-20.
 */
@Repository
public class ShopSiteIndexDao extends MyBatisBaseDao<ShopSiteIndexDto> {

    @Autowired
    @Getter
    private ShopSiteIndexMapper mapper;

    public ShopSiteIndexDto getShopSiteIndexByDomain(String domain){
        return this.mapper.loadShopSite(domain);
    }
}
