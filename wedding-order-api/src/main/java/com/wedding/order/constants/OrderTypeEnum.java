package com.wedding.order.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 14-9-17.
 */

/**
 * 订单类型枚举
 */
public enum OrderTypeEnum {

    HOTEL_ORDER(1,"酒店订单"),
    BRIDAL_ORDER(2,"婚纱订单"),
    MARRY_ORDER(3,"婚庆订单"),
    OTHER_ORDER(4,"其他订单");
    
    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(OrderTypeEnum type : OrderTypeEnum.values()){
    		typeMap.put(type.getIndex(), type.getTypeName());
    	}
    }

    private int index;

    private String typeName;

    OrderTypeEnum(int index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public int getIndex(){
        return index;
    }
    public String getTypeName(){
        return typeName;
    }
    
    public static String getOrderTypeName(int index){
    	return typeMap.get(index);
    }

}
