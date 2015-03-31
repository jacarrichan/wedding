package com.wedding.order.constants;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * 订单内部类型枚举
 * Created by Peter on 14-9-17.
 */
public enum OrderInternalTypeEnum {

    ORDER_INTERNAL_TYPE_ONLINE(1,"线上订单"),

    ORDER_INTERNAL_TYPE_NOT_ONLINE(2,"线下订单");

    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(OrderInternalTypeEnum type : OrderInternalTypeEnum.values()){
    		typeMap.put(type.getIndex(), type.getValue());
    	}
    }
    
    @Getter
    private int index;

    @Getter
    private String value;

     OrderInternalTypeEnum(int index, String value) {
         this.index = index;
         this.value = value;
    }

    public static String getOrderInternalTypeValue(int index){
    	return typeMap.get(index);
    }
}
