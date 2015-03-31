package com.wedding.seller.service;

import com.wedding.common.model.RequestResult;
import com.wedding.seller.dto.SellerCurdDto;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.ShopDto;
import org.springframework.stereotype.Service;

/**
 * Created by arroganter on 14-9-16.
 */
@Service
public interface SellerService {

    public int addShop(ShopDto shop);

    public SellerDto querySellerByUserId(String sellerId);
    
    public RequestResult update(SellerCurdDto seller);

    /**
     * 商家入驻接口
     * @param sellerDto
     */
    String registerSeller(SellerDto sellerDto);

	public RequestResult create(SellerCurdDto seller);
	
	String populateFullAddress(SellerDto record);

    SellerDto findParentById(String sellerId);


}
