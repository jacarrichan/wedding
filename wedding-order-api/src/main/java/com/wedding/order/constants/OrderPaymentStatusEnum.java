package com.wedding.order.constants;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * 订单支付状态枚举
 * Created by Peter on 14-9-17.
 */
public enum OrderPaymentStatusEnum {

    PAYMENT_FIRST(1,"已付初款"),

    PAYMENT_SECOND(2,"已付中款"),

    PAYMENT_FINISHED(3,"付款结束");
    
    
    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(OrderPaymentStatusEnum type : OrderPaymentStatusEnum.values()){
    		typeMap.put(type.getIndex(), type.getValue());
    	}
    }

    @Getter
    private int index;

    @Getter
    private String value;

    OrderPaymentStatusEnum(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public static String getOrderPaymentStatusValue(int index){
    	return typeMap.get(index);
    }
}
