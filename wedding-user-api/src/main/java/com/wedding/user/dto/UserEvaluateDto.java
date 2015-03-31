package com.wedding.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class UserEvaluateDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Integer type;

    @Getter
    @Setter
    private String sellerId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private Integer serviceQuota;

    @Getter
    @Setter
    private Integer envQuota;

    @Getter
    @Setter
    private Integer funPriceQuota;

    @Getter
    @Setter
    private Integer prodExpQuota;

    @Getter
    @Setter
    private Integer dosQuota;

    @Getter
    @Setter
    private Integer excessiveQuota;

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