package com.wedding.seller.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.seller.constants.SellerInternalStatusEnum;
import com.wedding.seller.constants.SellerTypeEnum;

@Service
public class SellerConstantsServiceImpl implements ISellerConstantsService {

	/**
	 * 商家类型
	 */
	@Override
	public ListResult<Pair<Integer, String>> getSellerType() {
		List<Pair<Integer, String>> results = new ArrayList<Pair<Integer, String>>();
		for(SellerTypeEnum type : SellerTypeEnum.values()){
			Pair<Integer, String> pair = new Pair<Integer, String>(type.getIndex(), type.getTypeName());
			results.add(pair);
		}
		return new ListResult<>(results);
	}

	/**
	 * 商家审核状态
	 */
	@Override
	public ListResult<Pair<Integer, String>> getSellerInternalStatus() {
		List<Pair<Integer, String>> results = new ArrayList<Pair<Integer, String>>();
		for(SellerInternalStatusEnum type : SellerInternalStatusEnum.values()){
			Pair<Integer, String> pair = new Pair<Integer, String>(type.getIndex(), type.getTypeName());
			results.add(pair);
		}
		return new ListResult<>(results);
	}


}
