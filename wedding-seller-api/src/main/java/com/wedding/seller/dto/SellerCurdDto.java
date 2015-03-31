package com.wedding.seller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SellerCurdDto implements Serializable {

	private static final long serialVersionUID = -2587227358489215365L;

	@Setter
    @Getter
	private String id;
	
    @Setter
    @Getter
    private String name;		//名称

    @Setter
    @Getter
    private String address;		//地址
    
    @Setter
    @Getter
    private String createTime;   

    @Setter
    @Getter
    private Byte type;		//行业类型
    
    @Setter
    @Getter
    private String parentId;

    @Setter
    @Getter
    private String parentName;	//上级公司名称	
       
    @Setter
    @Getter
    private String buildTime;		//公司成立时间
    
    @Getter
    @Setter
    private String domainId;
    
    @Setter
    @Getter
    private String domain;		//网址
    
    @Setter
    @Getter
    private String startTime;		//营业时间
   
    @Setter
    @Getter
    private String endTime;		//结束时间
    
    @Setter
    @Getter
    private String withdrawName;	//提现状态
    
    @Getter
    @Setter
    private Integer provinceCode;

    @Getter
    @Setter
    private Integer cityCode;

    @Getter
    @Setter
    private Integer regionCode;
    
    @Getter
    @Setter
    private Integer internalStatus;

}
