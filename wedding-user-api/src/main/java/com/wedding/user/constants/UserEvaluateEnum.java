package com.wedding.user.constants;

/**
 * Created by Peter on 14-10-5.
 */
public enum UserEvaluateEnum {

    APPOINT_EVAL(1,"预约评价"),
    ORDER_FINISHED_EVAL(2,"订单完成评价");

    private int index;

    private String typeName;

    UserEvaluateEnum(int index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public int getIndex(){
        return index;
    }
    public String getTypeName(){
        return typeName;
    }

}
