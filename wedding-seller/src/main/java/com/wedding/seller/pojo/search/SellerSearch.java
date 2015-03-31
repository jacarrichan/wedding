package com.wedding.seller.pojo.search;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "seller",type = "seller")
@ToString
public class SellerSearch implements Serializable {

	private static final long serialVersionUID = 6583323741521242356L;

	@Id
    @Setter
    @Getter
	private String id;
	
	@Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String name;		//名称
    
    @Setter
    @Getter
    private Integer provinceCode;
    
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

    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String address;		//地址
    
    @Setter
    @Getter
    private String fullAddress;
    
    @Setter
    @Getter
    private Date createTime;   
    
    @Setter
    @Getter
    private Byte type;			
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String typeName;		//行业类型
    
    @Setter
    @Getter
    private String parentId;

    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String parentName;	//上级公司名称	
    
    @Setter
    @Getter
    private Integer level;
    
    @Setter
    @Getter
    private String linsence;
    
    @Field(type=FieldType.Date, format=DateFormat.basic_date)
    @Setter
    @Getter
    private Date buildTime;		//公司成立时间
    
    @Getter
    @Setter
    private String domainId;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Setter
    @Getter
    private String domain;		//网址
    
    @Setter
    @Getter
    private String orgCode;		//组织机构代码证
    
    @Setter
    @Getter
    private String idCardA;
    
    @Setter
    @Getter
    private String idCardB;
    
    @Setter
    @Getter
    private String logo;
    
    @Field(type=FieldType.Date, format=DateFormat.basic_time)
    @Setter
    @Getter
    private Date startTime;		//营业时间
   
    @Field(type=FieldType.Date, format=DateFormat.basic_time)
    @Setter
    @Getter
    private Date endTime;		//结束时间
   
    @Setter
    @Getter
    private Integer withdraw;	
    
    @Setter
    @Getter
    private String withdrawName;	//提现状态
    
    @Getter
    @Setter
    private Integer internalStatus;
    
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    @Getter
    @Setter
    private String internalStatusName;	//审核状态
}