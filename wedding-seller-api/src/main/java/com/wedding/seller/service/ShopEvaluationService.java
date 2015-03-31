package com.wedding.seller.service;

import com.wedding.common.model.PageResult;
import com.wedding.seller.dto.ShopEvaluationDto;

import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public interface ShopEvaluationService {
    public List<ShopEvaluationDto> queryEvaByShopId(String shopId);
}
