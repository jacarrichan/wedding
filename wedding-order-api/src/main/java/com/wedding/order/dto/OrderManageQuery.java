package com.wedding.order.dto;

import com.wedding.common.dto.DateRange;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class OrderManageQuery {

	@Getter
	@Setter
	private DateRange createTimeRange;
	
	@Getter
	@Setter
	private String orderNum;
	
	@Getter
	@Setter
	private String orderBuyer;
	
	@Getter
	@Setter
	private Double beginAmount;
	
	@Getter
	@Setter
	private Double endAmount;
	
	@Getter
	@Setter
	private String shopName;
	
	@Getter
	@Setter
	private String appointId;
	
	@Getter
	@Setter
	private Integer orderType;
	
	@Getter
	@Setter
	private Integer orderPaymentStatus;
	
}
