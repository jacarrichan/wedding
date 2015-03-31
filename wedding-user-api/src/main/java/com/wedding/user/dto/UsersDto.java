package com.wedding.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chuweifeng on 14-9-15.
 */
public class UsersDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String mobileNo;


    @Getter
    @Setter
    private String realName;


    @Getter
    @Setter
    private Date brithday;


    @Getter
    @Setter
    private String nickName;


    @Getter
    @Setter
    private String domainId;

    @Getter
    @Setter
    private String userAccountId;


}
