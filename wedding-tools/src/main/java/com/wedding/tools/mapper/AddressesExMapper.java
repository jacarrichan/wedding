package com.wedding.tools.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.wedding.tools.pojo.Addresses;

public interface AddressesExMapper {

	@Select("select distinct(parent_id) from wd_addresses")
	@ResultType(Integer.class)
	List<Integer> findAllParentId();
	
	@Select("select * from wd_addresses")
	@ResultType(Addresses.class)
	List<Addresses> findAll();
}
