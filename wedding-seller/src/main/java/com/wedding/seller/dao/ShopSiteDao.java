package com.wedding.seller.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.mapper.ShopSiteIndexMapper;
import com.wedding.seller.mapper.ShopSiteMapper;
import com.wedding.seller.pojo.ShopSite;
import com.wedding.seller.pojo.ShopSiteExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-10-19.
 */
@Repository
public class ShopSiteDao extends MyBatisBaseDao<ShopSite> {

    @Autowired
    @Getter
    private ShopSiteMapper mapper;

    /**
     * 根据域名主键获取商家网站信息
     * @param domainId
     * @return
     */
    public ShopSite getShopSiteByDomainId(String domainId){
        ShopSiteExample example = new ShopSiteExample();
        ShopSiteExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        List<ShopSite> list = this.mapper.selectByExample(example);
        return list!=null&&list.size()>0?list.get(0):null;
    }
}
