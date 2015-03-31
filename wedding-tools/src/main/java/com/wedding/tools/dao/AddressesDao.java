package com.wedding.tools.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;

import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tools.mapper.AddressesExMapper;
import com.wedding.tools.mapper.AddressesMapper;
import com.wedding.tools.pojo.Addresses;
import com.wedding.tools.pojo.AddressesExample;

/**
 * @author rkzhang
 */
@Repository
public class AddressesDao extends MyBatisBaseDao<Addresses>{

	@Getter
	@Autowired
	private AddressesMapper mapper;
	
	@Autowired
	private AddressesExMapper addressesExMapper;
	
	public List<Addresses> findByPerentId(Integer parentId){
		AddressesExample example = new AddressesExample();
		AddressesExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		return mapper.selectByExample(example);
	}
	
	public List<Addresses> findAll(){
		return addressesExMapper.findAll();
	}

	public long countAll() {
		AddressesExample example = new AddressesExample();
		return mapper.countByExample(example);
	}

	public List<Addresses> findAllByPage(PageQuery page) {
		AddressesExample example = new AddressesExample();
		example.setOrderByClause(" id limit " + page.getStartNum() + ", " + page.getPageSize());
		return mapper.selectByExample(example);
	}
	
	public List<Integer> findAllParentId(){
		return addressesExMapper.findAllParentId();
	}

	public Addresses findId(Integer key) {
		return mapper.selectByPrimaryKey(key);
	}
}
