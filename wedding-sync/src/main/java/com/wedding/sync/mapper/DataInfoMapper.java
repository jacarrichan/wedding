package com.wedding.sync.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.wedding.sync.model.DataInfo;
import com.wedding.sync.pojo.DataSync;

public interface DataInfoMapper {

	List<Map<String, Object>> findByDBSync(DataSync sync);
	
	int update(@Param("sql")String sql);
	
	int save(@Param("sql")String sql);
	
	int delete(DataInfo dataInfo);
	
	int count(DataInfo dataInfo);
	
}
