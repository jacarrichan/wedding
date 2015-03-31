package com.wedding.items.service.impl;

import com.wedding.common.util.BeanUtils;
import com.wedding.items.dao.ItemsDescDao;
import com.wedding.items.dto.ItemsDescDto;
import com.wedding.items.service.ItemsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peter on 14-10-23.
 */
@Service("itemsDescService")
public class ItemsDescServiceImpl implements ItemsDescService {

    @Autowired
    private ItemsDescDao itemsDescDao;

    @Override
    public List<ItemsDescDto> getItemsDescByItemId(String itemId) {
        return BeanUtils.createBeanListByTarget(this.itemsDescDao.getItemsDescByItemId(itemId),ItemsDescDto.class);
    }
}
