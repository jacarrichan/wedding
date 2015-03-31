package com.wedding.order.constants;

/**
 * 婚纱订单枚举
 * Created by Peter on 14-9-17.
 */
public enum BridalOrderStatusEnum {
    ORDER_AGREED(1,"已签约"),
    ORDER_SHOTED(2,"已拍摄"),
    ORDER_FINISHED(3,"已完成");

    BridalOrderStatusEnum(int index, String value) {
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
