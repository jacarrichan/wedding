package com.wedding.seller.service;

import com.wedding.common.exception.SystemException;
import com.wedding.common.redis.WdRedisDao;
import com.wedding.common.util.BeanUtils;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.service.ItemsService;
import com.wedding.seller.dao.ShopSiteDao;
import com.wedding.seller.dao.ShopSiteIndexDao;
import com.wedding.seller.dto.ShopSiteDto;
import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.pojo.ShopSite;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peter on 14-10-19.
 */
@Log4j
@Service
public class ShopSiteServiceImpl implements ShopSiteService{

    @Autowired
    private ShopSiteDao shopSiteDao;

    @Autowired
    private ShopSiteIndexDao shopSiteIndexDao;

    @Autowired
    private WdRedisDao<ShopSiteIndexDto> wdRedisDao;

    @Autowired
    private ItemsService itemsService;


    @Override
    public ShopSiteDto getShopSiteByDomainId(String domainId) {
        ShopSite shopSite = this.shopSiteDao.getShopSiteByDomainId(domainId);
        return BeanUtils.createBeanByTarget(shopSite,ShopSiteDto.class);
    }

    @Override
    public ShopSiteIndexDto loadShopByDomain(String domain) {
        ShopSiteIndexDto shopSiteIndexDto = wdRedisDao.get(domain,ShopSiteIndexDto.class);
        if(null!=shopSiteIndexDto){
            return shopSiteIndexDto;
        }else{
            shopSiteIndexDto = this.shopSiteIndexDao.getShopSiteIndexByDomain(domain);
            if(shopSiteIndexDto==null){
                throw new SystemException("该域名不存在!");
            }else{
                List<ItemsDto> itemsDtoList = this.itemsService.getItemsByShopId(shopSiteIndexDto.getShopId());
                shopSiteIndexDto.setItems(itemsDtoList);
                wdRedisDao.setAsDefaultTimeOut(shopSiteIndexDto);
            }
        }
        return shopSiteIndexDto;
    }
}
