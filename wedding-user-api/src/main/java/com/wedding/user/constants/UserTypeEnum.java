package com.wedding.user.constants;

/**
 * Created by Tank on 14-9-20.
 */

/**
 * 用户类型枚举
 */
public enum UserTypeEnum {

    NORMALUSER(1,"普通用户"),
    SHOPUSER(2,"商家用户");

    private int index;

    private String typeName;

    UserTypeEnum(int index, String typeName) {
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
