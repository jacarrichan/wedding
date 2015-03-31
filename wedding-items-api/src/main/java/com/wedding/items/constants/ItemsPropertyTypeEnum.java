package com.wedding.items.constants;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public enum ItemsPropertyTypeEnum {

	STRING(1, "String"),
	
	INTEGER(2, "Integer"),
	
	FLOAT(3, "Float"),
	
	DATE(4, "Date"),
	
	DATE_TIME(5, "DateTime"),
	
	TEXT(6, "Text");
	
	 private static Map<Integer, String> typeMap = new HashMap<Integer, String>();
	 
	 private static Map<String, Integer> nameMap = new HashMap<String, Integer>();

    static{
    	for(ItemsPropertyTypeEnum type : ItemsPropertyTypeEnum.values()){
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
	
	ItemsPropertyTypeEnum(int type, String name){
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
