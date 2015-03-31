package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhua02 on 2015/1/12.
 */
public class ShopEvaluationDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String shopId;

    @Getter
    @Setter
    private double priceEva;

    @Getter
    @Setter
    private double serviceEva;

    @Getter
    @Setter
    private double invisibleEva;

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
    private int stat;
}
