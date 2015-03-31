package com.wedding.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.order.constants.AppointStatusEnum;
import com.wedding.order.service.IAppointcConstantsService;

@Service
public class AppointConstantsServiceImpl implements IAppointcConstantsService {

	@Override
	public ListResult<Pair<Integer, String>> getAppointStatus() {
		List<Pair<Integer, String>> reuslts = new ArrayList<Pair<Integer, String>>();
		for(AppointStatusEnum appointStat : AppointStatusEnum.values()){
			reuslts.add(new Pair<Integer, String>(appointStat.getIndex(), appointStat.getValue()));
    	}
		return new ListResult<Pair<Integer, String>>(reuslts);
	}

}
