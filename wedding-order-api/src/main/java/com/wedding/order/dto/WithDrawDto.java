package com.wedding.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chuweifeng on 14-9-29.
 */
public class WithDrawDto implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userAccountId;

    @Getter
    @Setter
    private String orderId;

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
