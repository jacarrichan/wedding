package com.wedding.seller.service;

import com.wedding.seller.dto.SellerProfileDto;

/**
 * Created by Peter on 14-10-9.
 */
public interface SellerProfileService {

    /**
     * 获取当前店铺积分
     * @return
     */
    int getScore(String sellerProfileId);

    /**
     * 更新店铺积分
     */
    void mergeScore(SellerProfileDto sellerProfileDto);

    /**
     * 保存商店配置信息
     */
    void save(SellerProfileDto sellerProfileDto);

}
