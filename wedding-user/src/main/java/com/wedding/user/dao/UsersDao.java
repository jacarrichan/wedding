package com.wedding.user.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.dto.UsersDto;
import com.wedding.user.mapper.UsersMapper;
import com.wedding.user.pojo.UserAccount;
import com.wedding.user.pojo.Users;
import com.wedding.user.pojo.UsersExample;
import com.wedding.user.pojo.UsersExample.Criteria;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by chuweifeng on 14-9-15.
 */
@Repository
public class UsersDao extends MyBatisBaseDao<Users> {
    @Autowired
    @Getter
    private UsersMapper mapper;

    public Users selectUsersByUserId(String userAccountDao){
        UsersExample usersExample = new UsersExample();
        Criteria criteria = usersExample.createCriteria();
        criteria.andUserAccountIdEqualTo(userAccountDao);
        List<Users> results = mapper.selectByExample(usersExample);
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

}
