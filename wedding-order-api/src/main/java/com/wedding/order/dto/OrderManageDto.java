package com.wedding.order.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 后台订单查询所用的Dto类
 * @author rkzhang
 *
 */
@ToString
public class OrderManageDto implements Serializable{

	private static final long serialVersionUID = -7696461720822857247L;

	@Getter
    @Setter
    private String id;
	
    @Getter
    @Setter
    private Byte orderTypeId;

    @Getter
    @Setter
    private String orderType;	//订单类型

    @Getter
    @Setter
    private String orderNo;			//订单号

    @Getter
    @Setter
    private Double orderTotal;		//订单总额

    @Getter
    @Setter
    private String orderBuyer;	//订单拥有者
    
    @Getter
    @Setter
    private String orderBuyerName; //订单拥有者姓名

    @Getter
    @Setter
    private String orderStatus;		//订单状态
    
    @Getter
    @Setter
    private Byte paymentStatusId;

    @Getter
    @Setter
    private String paymentStatus;		//支付状态

    @Getter
    @Setter
    private String appointId;		//预约编号
    
    @Getter
    @Setter
    private Byte orderIsOnlineId;		

    @Getter
    @Setter
    private String orderIsOnline;		//是否在线订单

    @Getter
    @Setter
    private String shopName;			//店铺ID

    @Getter
    @Setter
    private String sellerName;		//卖家编号

    @Getter
    @Setter
    private String buyerMobileNo;	//买家手机号
    
    @Getter
    @Setter
    private Date createTime;

}
