package com.wedding.admin.manager.dao;

import com.wedding.admin.manager.pojo.RoleExample;
import com.wedding.common.constants.DataStatus;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedding.admin.manager.mapper.RoleMapper;
import com.wedding.admin.manager.pojo.Role;
import com.wedding.common.mybatis.MyBatisBaseDao;

import java.util.List;

@Repository
public class RoleDao extends MyBatisBaseDao<Role>{

	@Autowired
	@Getter
	private RoleMapper mapper;

    public List<Role> findAll(){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andStatEqualTo(DataStatus.ENABLED);
        example.setOrderByClause(" create_time asc ");
        return mapper.selectByExample(example);
    }

	public int logicDelete(String roleId) {
		RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andStatEqualTo(DataStatus.ENABLED);
        criteria.andIdEqualTo(roleId);
        Role record = new Role();
        record.setStat(0);;
		return mapper.updateByExampleSelective(record, example);
        
	}
	
}
