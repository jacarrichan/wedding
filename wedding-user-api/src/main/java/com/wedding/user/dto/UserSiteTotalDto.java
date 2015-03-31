package com.wedding.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by chuweifeng on 14-10-8.
 */
public class UserSiteTotalDto {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private Integer viewCount;
    @Getter
    @Setter
    private String siteId;
    @Getter
    @Setter
    private String viewYear;
    @Getter
    @Setter
    private String viewMonth;
    @Getter
    @Setter
    private String viewDay;
    @Getter
    @Setter
    private String viewDate;    
    
    @Getter
    @Setter
    private String ip;

}
