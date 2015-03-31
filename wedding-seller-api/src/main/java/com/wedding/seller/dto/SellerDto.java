package com.wedding.seller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

@ToString
public class SellerDto implements Serializable {

	private static final long serialVersionUID = 6583323741521242356L;

    @Setter
    @Getter
	private String id;
	
    @Setter
    @Getter
    private String name;		//名称
    
    @Setter
    @Getter
    private Integer provinceCode;
    
    @Setter
    @Getter
    private String provinceName;
 
    @Setter
    @Getter
    private Integer cityCode;
    
    @Setter
    @Getter
    private String cityName;

    @Setter
    @Getter
    private Integer regionCode;
    
    @Setter
    @Getter
    private String regionName;

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
    
    @Setter
    @Getter
    private String typeName;		//行业类型
    
    @Setter
    @Getter
    private String parentId;

    @Setter
    @Getter
    private String parentName;	//上级公司名称	
    
    @Setter
    @Getter
    private Integer level;
    
    @Setter
    @Getter
    private String linsence;
    
    @Setter
    @Getter
    private Date buildTime;		//公司成立时间
    
    @Getter
    @Setter
    private String domainId;
    
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
    
    @Setter
    @Getter
    private Date startTime;		//营业时间
   
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
    
    @Getter
    @Setter
    private String internalStatusName;	//审核状态
}