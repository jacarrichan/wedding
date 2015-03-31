package com.wedding.tool.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class AddressesViewDto implements Serializable {

    @Getter
    @Setter
    private Integer proid;

    @Getter
    @Setter
    private String proname;

    @Getter
    @Setter
    private Short prolev;

    @Getter
    @Setter
    private Integer cityid;

    @Getter
    @Setter
    private String cityname;

    @Getter
    @Setter
    private Short citylev;

    @Getter
    @Setter
    private Integer regionid;

    @Getter
    @Setter
    private String regionname;

    @Getter
    @Setter
    private Short regionlev;

    @Getter
    @Setter
    private Integer parentId;
}