package com.wedding.items.service.impl;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.redis.WdRedisDao;
import com.wedding.common.util.BeanUtils;
import com.wedding.items.constants.ItemsTypeEnum;
import com.wedding.items.dao.ItemsDao;
import com.wedding.items.dao.ItemsDescDao;
import com.wedding.items.dto.ItemsDescDto;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.pojo.Items;
import com.wedding.items.pojo.ItemsDesc;
import com.wedding.items.pojo.search.ItemsSearch;
import com.wedding.items.repository.ItemsRepository;
import com.wedding.items.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuweifeng on 14-9-25.
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;
    
	@Autowired
	private ItemsDescDao itemsDescDao;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private WdRedisDao<ItemsDto> wdRedisDao;



    @Override
    public ItemsDto getItemsById(String Id) {
        return null;
    }

    @Override
    public ItemsDto getItemsBySku(String sku) {
        return null;
    }

    @Override
    public PageResult<ItemsDto> getItemsBySeller(String sellerId) {
        return null;
    }


    /**
     * 根据店铺编号获取商品列表
     * @param shopId
     * @param pageQuery
     * @return
     */
    @Override
    public PageResult<ItemsDto> getItemsByShopId(String shopId,PageQuery pageQuery) {
        List<Items> itemsList = this.itemsDao.getItemsByShopId(shopId,pageQuery);
        List<ItemsDto> ls = BeanUtils.createBeanListByTarget(itemsList,ItemsDto.class);
        return new PageResult<ItemsDto>(pageQuery,ls);
    }

    @Override
    public List<ItemsDto> getItemsByShopId(String shopId) {
        return BeanUtils.createBeanListByTarget(this.itemsDao.getItemsByShopId(shopId),ItemsDto.class);
    }

    /**
     * 查询店铺对应的产品信息
     * **/
    @Override
    public PageResult<ItemsDto> queryItem(ItemsDto itemsDto, PageQuery pageQuery) {
        List<Items> itemsList = this.itemsDao.queryItem(itemsDto,pageQuery);
        List<ItemsDto> itemsDtoList = new ArrayList<ItemsDto>();
        for(Items item : itemsList){
            ItemsDto nItemDto = new ItemsDto();
            BeanUtils.copyProperties(item, nItemDto);
            itemsDtoList.add(nItemDto);
        }
        return new PageResult<ItemsDto>(pageQuery,itemsDtoList);
    }

	@Override
	public RequestResult cancelPromotion(String itemId) {
		itemsDao.cancelPromotion(itemId);
		ItemsSearch search = itemsRepository.findOne(itemId);
		search.setItemType(ItemsTypeEnum.NORMAL.getType());
		itemsRepository.save(search);
		return new RequestResult(true, "撤销成功");
	}

    @Transactional
    @Override
    public void addItem(ItemsDto itemsDto) {
        Items items=new Items();
        BeanUtils.copyProperties(items, itemsDto);
        itemsDao.addItem(items);
        for(ItemsDescDto itemsDescDto : itemsDto.getItemsDesc()){
            ItemsDesc itemsDesc = new ItemsDesc();
            BeanUtils.copyProperties(itemsDescDto,itemsDesc);
            this.itemsDescDao.insert(itemsDesc);
        }
    }
}
