package com.wedding.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Peter on 14-9-15.
 */
public class UserFavoriteDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String shopSiteId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String content;

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
