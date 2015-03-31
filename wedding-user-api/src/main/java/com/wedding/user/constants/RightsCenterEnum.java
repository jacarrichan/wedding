package com.wedding.user.constants;

/**
 * Created by Peter on 14-02-10.
 */

/**
 * 用户类型枚举
 */
public enum RightsCenterEnum {

    VIRTUAL_INFO(1,"虚假信息"),
    SERVER_INFO(2,"服务纠纷"),
    COMPLAINT_INFO(3,"投诉"),
    ADVISE_INFO(4,"建议");

    private int index;

    private String typeName;

    RightsCenterEnum(int index, String typeName) {
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
