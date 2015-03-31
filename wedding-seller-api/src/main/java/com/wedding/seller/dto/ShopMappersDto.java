package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by yea01 on 2015/1/9.
 */
public class ShopMappersDto implements Serializable {

    @Getter
    @Setter
    private String shopId;

    @Getter
    @Setter
    private String shopName;

    @Getter
    @Setter
    private String logo;

    @Getter
    @Setter
    private int type;

    @Getter
    @Setter
    private String linsence;

    @Getter
    @Setter
    private Date buildTime;

    @Getter
    @Setter
    private String domain;

    @Getter
    @Setter
    private String provinceCode;

    @Getter
    @Setter
    private String provinceName;

    @Getter
    @Setter
    private String cityCode;

    @Getter
    @Setter
    private String cityName;

    @Getter
    @Setter
    private String regionCode;

    @Getter
    @Setter
    private String regionName;

    @Getter
    @Setter
    private String address;


    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private List<BranchMapperDto> BranchList;
}
