package com.wedding.items.service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.items.dto.ItemsDescDto;
import com.wedding.items.dto.ItemsDto;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品信息接口
 * Created by Peter on 14-9-18.
 */
@Service
public interface ItemsService {

    /**
     * 获取商品信息通过主键
     * @param Id
     */
    public ItemsDto getItemsById(String Id);

    /**
     * 获取商品信息通过SKU
     * @param sku
     * @return
     */
    public ItemsDto getItemsBySku(String sku);

    /**
     * 根据商家编号获取商品列表
     * @param sellerId
     * @return
     */
    public PageResult<ItemsDto> getItemsBySeller(String sellerId);


    /**
     * 根据商家编号获取商品列表
     * @param shopId
     * @return
     */
    public PageResult<ItemsDto> getItemsByShopId(String shopId,PageQuery pageQuery);

    /**
     * 根据商家编号获取商品列表
     * @param shopId
     * @return
     */
    public List<ItemsDto> getItemsByShopId(String shopId);


    public PageResult<ItemsDto> queryItem(ItemsDto itemsDto, PageQuery pageQuery);
    
    /**
     * 取消促销
     * @return
     */
    public RequestResult cancelPromotion(String itemId);

    /**
     *新增商品信息
     */
    public void addItem(ItemsDto itemsDto);
}
