package com.wedding.order.constants;

/**
 * 其他订单枚举
 * Created by Peter on 14-9-17.
 */
public enum OtherOrderStatusEnum {
    ORDER_AGREED(1,"已签约"),
    ORDER_FINISHED(3,"已完成");

    OtherOrderStatusEnum(int index, String value) {
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
