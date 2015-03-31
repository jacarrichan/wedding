package com.wedding.items.constants;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public enum ItemsTypeEnum {

	NORMAL(1, "普通商品"),
	
	SELLER_FOR_PROMOTION(2, "商家促销"),
	
	WEBSITE_FOR_PROMOTION(3, "网站促销");
	
	 private static Map<Integer, String> typeMap = new HashMap<Integer, String>();
	 
	 private static Map<String, Integer> nameMap = new HashMap<String, Integer>();

    static{
    	for(ItemsTypeEnum type : ItemsTypeEnum.values()){
    		typeMap.put(type.getType(), type.getName());
    		nameMap.put(type.getName(), type.getType());
    	}
    }
	
	@Getter
	@Setter
	private int type;
	
	@Getter
	@Setter
	private String name;
	
	ItemsTypeEnum(int type, String name){
		this.type = type;
		this.name = name;
	}
	
	 public static String getName(int type) {
		 return typeMap.get(type);
	 }
	 
	 public static Integer getType(String name) {
		 return nameMap.get(name);
	 }
}
