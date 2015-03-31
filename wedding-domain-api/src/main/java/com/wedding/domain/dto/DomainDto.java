package com.wedding.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class DomainDto implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String domainName;

    @Getter
    @Setter
    private String domain;

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