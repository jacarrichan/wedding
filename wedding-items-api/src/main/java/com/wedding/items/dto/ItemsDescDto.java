package com.wedding.items.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品描述Dto
 */
public class ItemsDescDto {
	
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String itemDescKey;

    @Getter
    @Setter
    private String itemDescValue;

    @Getter
    @Setter
    private String itemId;

    @Getter
    @Setter
    private String itemDescTextValue;

}