package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SellerManageQuery {

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private Integer sellerType;
	
	@Getter
	@Setter
	private Integer internalStatus;
	
	@Getter
	@Setter
	private Integer province;
	
	@Getter
	@Setter
	private Integer city;
	
	@Getter
	@Setter
	private Integer districts;
	
}
