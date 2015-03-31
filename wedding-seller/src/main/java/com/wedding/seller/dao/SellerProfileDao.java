package com.wedding.seller.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.seller.mapper.SellerProfileMapper;
import com.wedding.seller.pojo.SellerProfile;
import com.wedding.seller.pojo.SellerProfileExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by arroganter on 14-9-16.
 */
@Repository
public class SellerProfileDao extends MyBatisBaseDao<SellerProfile> {
    @Autowired
    @Getter
    private SellerProfileMapper mapper;

    /**
     * 更新积分
     * @param score
     */
    public void updateScore(int score){
        SellerProfileExample example = new SellerProfileExample();
        SellerProfile sellerProfile = new SellerProfile();
        sellerProfile.setScore(score);
        this.getMapper().updateByExampleSelective(sellerProfile,example);
    }

}
