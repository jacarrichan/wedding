package com.wedding.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约Dto
 */
public class AppointDto implements Serializable {

	private static final long serialVersionUID = 7186103451447860936L;

	@Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userId;
    
    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String sellerId;
    
    @Getter
    @Setter
    private String sellerName;

    @Getter
    @Setter
    private String mobileNo;

    @Getter
    @Setter
    private String telephone;

    @Getter
    @Setter
    private Date appointTime;

    @Getter
    @Setter
    private Byte appointStatus;
    
    @Getter
    @Setter
    private String appointStatusName;

    @Getter
    @Setter
    private String memo;

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