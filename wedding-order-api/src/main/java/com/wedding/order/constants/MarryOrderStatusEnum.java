package com.wedding.order.constants;

/**
 * 婚庆订单枚举
 * Created by Peter on 14-9-17.
 */
public enum MarryOrderStatusEnum {
    ORDER_AGREED(1,"已签约"),
    ORDER_SERVICING(2,"服务中"),
    ORDER_FINISHED(3,"已完成");

    MarryOrderStatusEnum(int index, String value) {
        this.index = index;
        this.value = value;
    }

    private int index;

    private String value;

    public int getIndex(){
        return index;
    }

    public String getValue(){
        return value;
    }

}
