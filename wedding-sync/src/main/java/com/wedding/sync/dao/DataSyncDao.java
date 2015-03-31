package com.wedding.sync.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.sync.mapper.DataSyncMapper;
import com.wedding.sync.pojo.DataSync;
import com.wedding.sync.pojo.DataSyncExample;


@Repository
public class DataSyncDao extends MyBatisBaseDao<DataSync> {
	
	@Autowired
	private DataSyncMapper dbSyncMapper;
	
	
	public List<DataSync> findAll(Integer max){
		
		return dbSyncMapper.findAll(max);
	}
	
	public List<DataSync> findAllErrRecord(Integer start, Integer maxLength){
		
		return dbSyncMapper.findAllErrRecord(start, maxLength);
	}
	
	public int deleteByPrimaryKey(Integer id){
		return dbSyncMapper.deleteByPrimaryKey(id);
	}

	public int updateErrorInfo(Integer id, String info){
		return dbSyncMapper.updateErrorInfo(id, info);
	}
	
	public int countNeedReSendRecord(){
		DataSyncExample example = new DataSyncExample();
		DataSyncExample.Criteria criteria = example.createCriteria();
		criteria.andErrInfoIsNotNull();
		return dbSyncMapper.countByExample(example);
	}
	@Override
	public Object getMapper() {
		return dbSyncMapper;
	}

	public int updateByPrimaryKeySelective(DataSync record){
		return dbSyncMapper.updateByPrimaryKeySelective(record);
	}
}
