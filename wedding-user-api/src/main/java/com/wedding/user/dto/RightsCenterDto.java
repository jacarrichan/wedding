package com.wedding.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class RightsCenterDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userAccountId;

    @Getter
    @Setter
    private Integer type;

    @Getter
    @Setter
    private String sellerName;

    @Getter
    @Setter
    private String itemName;

    @Getter
    @Setter
    private String orderNo;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String attachment;

    @Getter
    @Setter
    private String contactInfo;

    @Getter
    @Setter
    private Integer internalStatus;

    @Getter
    @Setter
    private String statusName;

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