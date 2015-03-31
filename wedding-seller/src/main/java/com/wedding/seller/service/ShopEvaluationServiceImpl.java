package com.wedding.seller.service;

import com.wedding.common.util.BeanUtils;
import com.wedding.seller.dao.ShopEvaluationDao;
import com.wedding.seller.dto.ShopEvaluationDto;
import com.wedding.seller.pojo.ShopEvaluation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhua02 on 2015/1/12.
 */
public class ShopEvaluationServiceImpl implements  ShopEvaluationService {
    @Autowired
    private ShopEvaluationDao shopEvaluationDao;

    @Override
    public List<ShopEvaluationDto> queryEvaByShopId(String shopId) {
        List<ShopEvaluation> resultList = shopEvaluationDao.queryEvaByShopId(shopId);
        List<ShopEvaluationDto> ShopEvaluationDtoList =new ArrayList<ShopEvaluationDto>();
        for(ShopEvaluation shopEvaluation:resultList){
            ShopEvaluationDto shopEvaluationDto = new ShopEvaluationDto();
            BeanUtils.copyProperties(shopEvaluation,shopEvaluationDto);
            ShopEvaluationDtoList.add(shopEvaluationDto);
        }
        return ShopEvaluationDtoList;
    }
}
