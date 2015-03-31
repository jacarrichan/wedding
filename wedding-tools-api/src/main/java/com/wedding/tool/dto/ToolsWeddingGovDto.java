package com.wedding.tool.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tank on 14-9-26.
 */

/**
 * 结婚登记处DTO
 */
public class ToolsWeddingGovDto implements Serializable {


    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String province;

    @Getter
    @Setter
    private String business_hours;

    @Getter
    @Setter
    private Integer xPoint;

    @Getter
    @Setter
    private Integer yPoint;


}
