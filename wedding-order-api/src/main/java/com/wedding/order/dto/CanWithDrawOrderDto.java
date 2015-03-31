package com.wedding.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by pc-tank on 15-1-9.
 */
public class CanWithDrawOrderDto {
    @Getter
    @Setter
    private String id;


    @Getter
    @Setter
    private String orderTypeId;

    @Getter
    @Setter
    private String orderNo;

    @Getter
    @Setter
    private String orderStatus;

    @Getter
    @Setter
    private String paymentStatusId;

    @Getter
    @Setter
    private String appointId;

    @Getter
    @Setter
    private String shopName;

    @Getter
    @Setter
    private String shop_id;

    @Getter
    @Setter
    private Integer orderTotal;

    @Getter
    @Setter
    private String orderIsOnlineId;

    @Getter
    @Setter
    private String itemId;

    @Getter
    @Setter
    private String item_name;

    @Getter
    @Setter
    private String item_active_title;

    @Getter
    @Setter
    private Integer item_total;

    @Getter
    @Setter
    private String main_pic;

    @Getter
    @Setter
    private String shopId;

    @Getter
    @Setter
    private Date createTime;

}
