package com.wedding.seller.dao;

import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.seller.dto.BranchMapperDto;
import com.wedding.seller.dto.ShopMappersDto;
import com.wedding.seller.mapper.FindShopMapper;
import com.wedding.seller.mapper.ShopMapper;
import com.wedding.seller.pojo.Shop;
import com.wedding.seller.pojo.ShopExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by arroganter on 14-9-18.
 */
@Repository
public class ShopDao extends MyBatisBaseDao<Shop> {

    @Autowired
    @Getter
    private ShopMapper mapper;

    @Autowired
    @Getter
    private FindShopMapper findShopMapper;


    public List<Shop> queryShopByParam(PageQuery pageQuery){
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(" id desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }
    public ShopMappersDto findShopByUserId(String id){

        return this.findShopMapper.findShopByUser(id);
    }
    public List<BranchMapperDto> findBranchByParentUser(String id){
        return findShopMapper.findBranchByParent(id);
    }
    public Map<Object,Object> findAddresses(String id){
           return this.findShopMapper.findAddress(id);
    }
}
