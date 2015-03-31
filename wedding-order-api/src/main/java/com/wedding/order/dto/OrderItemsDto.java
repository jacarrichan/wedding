package com.wedding.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单明细数据传输模型
 */
public class OrderItemsDto implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String orderId;

    @Getter
    @Setter
    private String itemName;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Integer activeId;

    @Getter
    @Setter
    private String itemId;

    @Getter
    @Setter
    private Integer discountFee;

    @Getter
    @Setter
    private Integer itemTotal;

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

}