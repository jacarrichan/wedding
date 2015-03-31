package com.wedding.seller.service;

import com.wedding.common.util.BeanUtils;
import com.wedding.seller.dao.SellerProfileDao;
import com.wedding.seller.dto.SellerProfileDto;
import com.wedding.seller.pojo.SellerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Peter on 14-10-9.
 */
@Service
public class SellerProfileServiceImpl implements SellerProfileService {

    @Autowired
    private SellerProfileDao sellerProfileDao;

    @Override
    public int getScore(String sellerProfileId) {
        SellerProfile sellerProfile = this.sellerProfileDao.getMapper().selectByPrimaryKey(sellerProfileId);
        return sellerProfile.getScore();
    }

    @Override
    public synchronized void mergeScore(SellerProfileDto sellerProfileDto) {
        int currentScore = this.getScore(sellerProfileDto.getId());
        int finalScore = currentScore+sellerProfileDto.getScore();
        this.sellerProfileDao.updateScore(finalScore);
    }

    @Override
    public void save(SellerProfileDto sellerProfileDto) {
        SellerProfile sellerProfile = BeanUtils.createBeanByTarget(sellerProfileDto,SellerProfile.class);
        this.sellerProfileDao.insert(sellerProfile);
    }
}
