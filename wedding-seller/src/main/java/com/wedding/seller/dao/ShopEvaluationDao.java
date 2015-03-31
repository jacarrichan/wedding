package com.wedding.seller.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.seller.mapper.ShopEvaluationMapper;
import com.wedding.seller.pojo.ShopEvaluation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public class ShopEvaluationDao extends MyBatisBaseDao<ShopEvaluation> {

    @Autowired
    @Getter
    private ShopEvaluationMapper mapper;

    public List<ShopEvaluation> queryEvaByShopId(String shopId){
        return this.mapper.queryEvaByShopId(shopId);
    }
}
