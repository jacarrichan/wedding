package com.wedding.sync.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.wedding.common.exception.SystemException;
import com.wedding.sync.dao.DataSyncDao;
import com.wedding.sync.factory.DataHandlerFactory;
import com.wedding.sync.handler.IDataHandler;
import com.wedding.sync.model.DataInfo;
import com.wedding.sync.pojo.DataSync;
import com.wedding.sync.service.IDataInfoBulider;
import com.wedding.sync.service.IDataSyncService;

@Service
public class DataSyncServiceImpl implements IDataSyncService {
	
	protected static final Log logger = LogFactory.getLog(DataSyncServiceImpl.class);

	@Autowired
	private DataSyncDao syncDao;
	
	@Autowired
	private IDataInfoBulider infoBulider;
	
	@Override
	public int countNeedReSendData() {
		return syncDao.countNeedReSendRecord();
	}

	
	@Override
	public List<DataInfo> findNeedSendData(Integer maxLength) {
		List<DataInfo> results = new ArrayList<DataInfo>();
		
		List<DataSync> datas = syncDao.findAll(maxLength);
		for(DataSync data : datas){
			List<DataInfo> infos = infoBulider.populateDataInfo(data);
			if(!CollectionUtils.isEmpty(infos)){
				results.addAll(infos);
			}
		}
		
		return results;
	}
	
	@Override
	public List<DataInfo> findNeedReSendData(Integer start, Integer maxLength) {
		List<DataInfo> results = new ArrayList<DataInfo>();
		
		List<DataSync> datas = syncDao.findAllErrRecord(start, maxLength);
		for(DataSync data : datas){
			List<DataInfo> infos = infoBulider.populateDataInfo(data);
			if(!CollectionUtils.isEmpty(infos)){
				results.addAll(infos);
			}
		}
		
		return results;
	}

	public void syncData(DataInfo data) {
		try {
			IDataHandler sendProcessor = DataHandlerFactory.findDataProcessor(data.getTableName());
			
			//如有配制处理器,需处理器做特例处理			
			switch (data.getOptType()) {
			case New:
				sendProcessor.create(data);
				break;
			case Update:
				sendProcessor.update(data);
				break;
			case Delete:
				sendProcessor.delete(data);
				break;
			default:
				break;
			}
			
			
			processSucessed(data);
			
		} catch (Throwable e) {
			processfail(data, e.getMessage());
			e.printStackTrace();
			throw new SystemException(e.getMessage());
		}
		
	}

	private void processfail(DataInfo data, String result) {
		syncDao.updateErrorInfo(data.getDbSyncId(), result);
	}

	private void processSucessed(DataInfo data) {
		syncDao.deleteByPrimaryKey(data.getDbSyncId());
	}

}
