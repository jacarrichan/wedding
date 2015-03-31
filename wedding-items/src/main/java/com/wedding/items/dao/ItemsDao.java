package com.wedding.items.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.items.constants.ItemsTypeEnum;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.mapper.ItemsMapper;
import com.wedding.items.pojo.Items;
import com.wedding.items.pojo.ItemsExample;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-9-15.
 */
@Repository
public class ItemsDao extends MyBatisBaseDao<Items> {

    @Autowired
    @Getter
    private ItemsMapper mapper;

    public List<Items> getItemsByShopId(String shopId, PageQuery pageQuery) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andSellerIdEqualTo(shopId);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        itemsExample.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(itemsExample);
    }

    public List<Items> getItemsByShopId(String shopId) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        return this.mapper.selectByExample(itemsExample);
    }

    public List<Items> queryItem(ItemsDto itemsDto, PageQuery pageQuery) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        if(!StringUtils.isEmpty(itemsDto.getSellerId())){
            criteria.andSellerIdEqualTo(itemsDto.getSellerId());
        }
        criteria.andStatEqualTo(DataStatus.ENABLED);
        itemsExample.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(itemsExample);
    }
    
    public List<Items> queryItem(PageQuery pageQuery) {
    	ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        
        criteria.andStatEqualTo(DataStatus.ENABLED);
        itemsExample.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(itemsExample);
    }
    
    public long countAll(){
    	ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        
        criteria.andStatEqualTo(DataStatus.ENABLED);
        return this.mapper.countByExample(itemsExample);
    }

	public void cancelPromotion(String itemId) {
		ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        Items item = new Items();
        item.setItemType(ItemsTypeEnum.NORMAL.getType());
        this.mapper.updateByExampleSelective(item, itemsExample);
	}

    public void addItem(Items items){
        this.mapper.insert(items);
    }
}
