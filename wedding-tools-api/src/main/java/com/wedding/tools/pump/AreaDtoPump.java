package com.wedding.tools.pump;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.wedding.tool.service.IAreaQueryService;

@Service
public class AreaDtoPump implements Runnable {

	protected static final Log logger = LogFactory.getLog(AreaDtoPump.class);
	
	@Autowired
	private IAreaQueryService areaQueryService;

	@Override
	public void run() {
		areaQueryService.deleteAllInRedis();
		List<Integer> parentIds = areaQueryService.findAllParentId();
		if(CollectionUtils.isEmpty(parentIds)) {
			return;
		}
		
		for(Integer parentId : parentIds){
			try {
				areaQueryService.findByParentId(parentId);			
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				continue;
			}
		}
		
	}

}
