package com.wedding.seller.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.seller.mapper.SellerMapper;
import com.wedding.seller.pojo.Seller;
import com.wedding.seller.pojo.SellerExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import java.util.List;

/**
 * Created by arroganter on 14-9-16.
 */
@Repository
public class SellerDao extends MyBatisBaseDao<Seller> {
    @Autowired
    @Getter
    private SellerMapper mapper;


    public Seller querySellerByUserId(String sellerId) {
        SellerExample example = new SellerExample();
        SellerExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(sellerId);
        List<Seller> sellers = mapper.selectByExample(example);
        return CollectionUtils.isEmpty(sellers) ? null : sellers.get(0);
    }
}
