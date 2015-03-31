package com.wedding.domain.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.domain.mapper.DomainMapper;
import com.wedding.domain.pojo.Domain;
import com.wedding.domain.pojo.DomainExample;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-10-15.
 */
@Repository
public class DomainDao extends MyBatisBaseDao<Domain> {

    @Autowired
    @Getter
    private DomainMapper mapper;

    /**
     * 获取域名信息By域名
     * @param domain
     * @return
     */
    public Domain getDomain(String domain){
        DomainExample example = new DomainExample();
        DomainExample.Criteria criteria = example.createCriteria();
        criteria.andDomainEqualTo(domain);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        List<Domain> list = this.mapper.selectByExample(example);
        return list!=null&&list.size()>0?list.get(0):null;
    }

}
