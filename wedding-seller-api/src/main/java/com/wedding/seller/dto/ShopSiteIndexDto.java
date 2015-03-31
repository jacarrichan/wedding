package com.wedding.seller.dto;

import com.wedding.common.redis.RedisKeyPrefix;
import com.wedding.items.dto.ItemsDto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 14-10-20.
 */
@RedisKeyPrefix(prefixValue="seller:ShopSiteIndexDto:domain")
public class ShopSiteIndexDto implements Serializable {
    @Getter
    @Setter
    private String shopId;
    @Getter
    @Setter
    private String shopName;
    @Getter
    @Setter
    private String domain;
    @Getter
    @Setter
    private String qq;
    @Getter
    @Setter
    private int score;
    @Getter
    @Setter
    private List<ItemsDto> items = new ArrayList<ItemsDto>();

}
