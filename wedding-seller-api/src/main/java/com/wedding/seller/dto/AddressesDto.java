package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by yea01 on 2015/1/12.
 */
public class AddressesDto implements Serializable {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int parentId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int level;
}
