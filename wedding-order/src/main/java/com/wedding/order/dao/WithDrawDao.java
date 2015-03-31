package com.wedding.order.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.order.dto.WithDrawDto;
import com.wedding.order.mapper.WithDrawMapper;
import com.wedding.order.pojo.Appoint;
import com.wedding.order.pojo.OrdersExample;
import com.wedding.order.pojo.WithDraw;
import com.wedding.order.pojo.WithDrawExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 体现单处理dao
 * Created by chuweifeng on 14-9-29.
 */
@Repository
public class WithDrawDao extends MyBatisBaseDao<WithDraw> {
    @Autowired
    @Getter
    private WithDrawMapper mapper;

    public List<WithDraw> query(WithDrawDto withDrawDto, PageQuery pageQuery) {
        WithDrawExample example = new WithDrawExample();
        WithDrawExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountIdEqualTo(withDrawDto.getUserAccountId());
        example.setOrderByClause(" id desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }
}
