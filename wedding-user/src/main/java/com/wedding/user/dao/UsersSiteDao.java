package com.wedding.user.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.mapper.UserSiteMapper;
import com.wedding.user.pojo.UserSite;
import com.wedding.user.pojo.UserSiteExample;
import com.wedding.user.pojo.UserSiteExample.Criteria;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by chuweifeng on 14-9-15.
 */
@Repository
public class UsersSiteDao extends MyBatisBaseDao<UserSite> {
    @Autowired
    @Getter
    private UserSiteMapper mapper;

    public UserSite selectUsersSiteById(String siteId){
        UserSiteExample userSiteExample = new UserSiteExample();
        Criteria criteria = userSiteExample.createCriteria();
        criteria.andIdEqualTo(siteId);
        List<UserSite> results = mapper.selectByExample(userSiteExample);
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

}
