package com.wedding.items.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 商品Dto
 */
@ToString
public class ItemsDto implements Serializable{

	private static final long serialVersionUID = 134435834623627972L;

	@Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String itemName;			//商品名称

    @Getter
    @Setter
    private String itemActiveTitle;		//商品口号

    @Getter
    @Setter
    private Double itemMarketPrice;	//商品价格

    @Getter
    @Setter
    private Double itemFactPrice;		//商品实际价格

    @Getter
    @Setter
    private Double itemFinalPrice;		//聚喜价
    
    @Getter
    @Setter
    private String mainPic;

    @Getter
    @Setter
    private String sellerId;
    
    @Getter
    @Setter
    private String sellerName;			//商家名称
    
    @Getter
    @Setter
    private Byte sellerType; 
    
    @Getter
    @Setter
    private Integer itemType;
    
    @Getter
    @Setter
    private String itemTypeName;

    @Getter
    @Setter
    private String shopId;
    
    @Getter
    @Setter
    private String shopName;			//店铺名称

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

    @Getter
    @Setter
    private List<ItemsDescDto> itemsDesc = new ArrayList<ItemsDescDto>();


}