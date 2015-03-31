package com.wedding.seller.mapper;

import com.wedding.seller.pojo.ShopEvaluation;

import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public interface ShopEvaluationMapper {
    List<ShopEvaluation> queryEvaByShopId(String shopId);
}
