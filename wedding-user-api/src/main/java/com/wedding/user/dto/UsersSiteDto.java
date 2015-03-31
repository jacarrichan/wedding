package com.wedding.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chuweifeng on 14-9-15.
 */
public class UsersSiteDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Integer viewCount;

}
