package com.wedding.items.service;

import com.wedding.items.dto.ItemsDescDto;

import java.util.List;

/**
 * Created by Peter on 14-10-23.
 */
public interface ItemsDescService {

    /**
     * 根据商品编号获取商品描述信息
     * @param itemId
     * @return
     */
    public List<ItemsDescDto> getItemsDescByItemId(String itemId);

}
