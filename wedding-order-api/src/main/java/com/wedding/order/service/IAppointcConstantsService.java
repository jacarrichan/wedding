package com.wedding.order.service;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;

@Service
public interface IAppointcConstantsService {

	ListResult<Pair<Integer, String>> getAppointStatus();
}
