package com.wedding.items.pojo.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * 商品Dto
 */
@Document(indexName = "items",type = "items")
@ToString
public class ItemsSearch implements Serializable{

	private static final long serialVersionUID = 134435834623627972L;

	@Id
	@Getter
    @Setter
    private String id;

	@Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Getter
    @Setter
    private String itemName;			//商品名称

    @Getter
    @Setter
    private String itemActiveTitle;		//商品口号

    @Getter
    @Setter
    private Integer itemMarketPrice;	//商品价格

    @Getter
    @Setter
    private Integer itemFactPrice;		//商品实际价格

    @Getter
    @Setter
    private Integer itemFinalPrice;		//聚喜价
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Getter
    @Setter
    private String mainPic;

    @Getter
    @Setter
    private String sellerId;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
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
    private String shopId;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
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
    private List<ItemsDescSearch> itemsDesc = new ArrayList<ItemsDescSearch>();

}