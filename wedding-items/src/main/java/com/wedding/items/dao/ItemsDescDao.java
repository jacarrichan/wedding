package com.wedding.items.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.items.mapper.ItemsDescMapper;
import com.wedding.items.pojo.ItemsDesc;
import com.wedding.items.pojo.ItemsDescExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-10-23.
 */
@Repository
public class ItemsDescDao extends MyBatisBaseDao<ItemsDesc> {

    @Autowired
    @Getter
    private ItemsDescMapper mapper;

    /**
     * 获取商品描述信息
     * @param itemId
     * @return
     */
    public List<ItemsDesc> getItemsDescByItemId(String itemId){
        ItemsDescExample example = new ItemsDescExample();
        ItemsDescExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        return mapper.selectByExampleWithBLOBs(example);
        // return this.mapper.selectByExample(example);
    }

    public void saveItemsDesc(ItemsDesc itemsDesc){
        this.mapper.insert(itemsDesc);
    }

}
