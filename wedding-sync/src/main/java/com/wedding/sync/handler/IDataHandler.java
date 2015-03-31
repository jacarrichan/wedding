package com.wedding.sync.handler;

import com.wedding.sync.model.DataInfo;

public interface IDataHandler {
	
	void create(DataInfo dataInfo);
	
	void update(DataInfo dataInfo);
	
	void delete(DataInfo dataInfo);
	
}
