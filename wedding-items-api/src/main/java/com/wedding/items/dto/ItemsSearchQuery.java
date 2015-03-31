package com.wedding.items.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ItemsSearchQuery {

    @Getter
    @Setter
    private String itemName;
    
    @Getter
    @Setter
    private String sellerName;
    
    @Getter
    @Setter
    private String shopName;
    
    @Getter
    @Setter
    private Integer itemsType;
    
}
