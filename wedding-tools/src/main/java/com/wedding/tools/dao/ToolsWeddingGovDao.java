package com.wedding.tools.dao;

import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.tools.mapper.ToolsWeddingGovMapper;
import com.wedding.tools.pojo.ToolsWeddingGov;
import com.wedding.tools.pojo.ToolsWeddingGovExample;
import com.wedding.tools.pojo.ToolsWeddingGovExample.Criteria;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Repository
public class ToolsWeddingGovDao extends MyBatisBaseDao<ToolsWeddingGov> {

    @Getter
    @Autowired
    private ToolsWeddingGovMapper mapper;

    public List<ToolsWeddingGov> findByCityAndProvince(ToolsWeddingGov toolsWeddingGov,PageQuery pageQuery){
        ToolsWeddingGovExample example = new ToolsWeddingGovExample();
        Criteria criteria = example.createCriteria();
        criteria.andCityEqualTo(toolsWeddingGov.getCity());
        criteria.andProvinceEqualTo(toolsWeddingGov.getProvince());
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        List<ToolsWeddingGov> results = mapper.selectByExample(example);

        return CollectionUtils.isEmpty(results) ? null : results;
    }

    public List<ToolsWeddingGov> findByProvince(ToolsWeddingGov toolsWeddingGov,PageQuery pageQuery){
        ToolsWeddingGovExample example = new ToolsWeddingGovExample();
        Criteria criteria = example.createCriteria();
        criteria.andProvinceEqualTo(toolsWeddingGov.getProvince());
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        List<ToolsWeddingGov> results = mapper.selectByExample(example);
        return CollectionUtils.isEmpty(results) ? null : results;
    }


}
