package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class ShopSiteDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String shopId;

    @Getter
    @Setter
    private Integer integral;

    @Getter
    @Setter
    private String qq;

    @Getter
    @Setter
    private String domainId;

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