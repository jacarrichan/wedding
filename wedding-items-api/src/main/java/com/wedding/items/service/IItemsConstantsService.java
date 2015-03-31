package com.wedding.items.service;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;

@Service
public interface IItemsConstantsService {

	ListResult<Pair<Integer, String>> getPropertyType();

	ListResult<Pair<Integer, String>> getItemsType();

}
