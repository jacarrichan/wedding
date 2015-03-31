package com.wedding.seller.pojo.search;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "shop",type = "shop")
@ToString
public class ShopSearch implements Serializable {

	private static final long serialVersionUID = -5351030820193804589L;

	@Id
	@Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String logo;

    @Getter
    @Setter
    private String sellerId;
    
    @Getter
    @Setter
    private String sellerName;
    
    @Setter
    @Getter
    private Integer provinceCode;
    
    @Setter
    @Getter
    private Integer activityType;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String provinceName;
 
    @Setter
    @Getter
    private Integer cityCode;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String cityName;

    @Setter
    @Getter
    private Integer regionCode;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String regionName;

    @Getter
    @Setter
    private Date createTime;

}
