package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by yea01 on 2015/1/12.
 */
public class RightCenterDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userAccountId;

    @Getter
    @Setter
    private int type;

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
    private String internalStatus;

    @Getter
    @Setter
    private Date createTime;

}
