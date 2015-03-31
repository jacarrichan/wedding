package com.wedding.sync.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wedding.sync.model.DataInfo;
import com.wedding.sync.pojo.DataSync;

@Service
public interface IDataInfoBulider {

	List<DataInfo> populateDataInfo(DataSync dbSync);
}
