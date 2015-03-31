package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class ShopDto implements Serializable {


	@Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String logo;

    @Getter
    @Setter
    private String sellerId;
    
    @Setter
    @Getter
    private Integer activityType;

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