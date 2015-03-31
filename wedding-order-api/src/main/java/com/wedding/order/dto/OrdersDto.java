package com.wedding.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDto implements Serializable{

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Byte orderType;

    @Getter
    @Setter
    private String orderNo;

    @Getter
    @Setter
    private Integer orderTotal;

    @Getter
    @Setter
    private String orderBuyerId;

    @Getter
    @Setter
    private String orderStatus;

    @Getter
    @Setter
    private Byte paymentStatus;

    @Getter
    @Setter
    private String appointId;

    @Getter
    @Setter
    private Date createTime;

    @Getter
    @Setter
    private String createPerson;

    @Getter
    @Setter
    private Date lastUpdateTime;

    @Getter
    @Setter
    private String lastUpdatePerson;

    @Getter
    @Setter
    private Integer stat;

    @Getter
    @Setter
    private Byte orderIsOnline;

    @Getter
    @Setter
    private String shopId;

    @Getter
    @Setter
    private String sellerId;

    @Getter
    @Setter
    private String buyerMobileNo;

    @Getter
    @Setter
    private List<OrderItemsDto> orderItemsDtoList = new ArrayList<OrderItemsDto>();


}