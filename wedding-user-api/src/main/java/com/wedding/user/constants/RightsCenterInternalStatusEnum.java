package com.wedding.user.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlfredYe
 * 维权内部状态枚举类
 */
public enum RightsCenterInternalStatusEnum {

    APPLY_PROCESSING(1,"待审核"),

    APPLY_SUCCESS(2,"审核成功"),

    APPLY_NO_SUCCESS(3,"审核未通过"),

    APPLY_BEING_PROCESS(4,"正在处理"),

    APPLY_REVOKE(5,"撤销"),

    APPLY_BEING_SURVEY(6,"取证中"),
    APPLY_FINISH(7,"已结束");

    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(RightsCenterInternalStatusEnum type : RightsCenterInternalStatusEnum.values()){
    		typeMap.put(type.getIndex(), type.getTypeName());
    	}
    }

    private int index;

    private String typeName;

    RightsCenterInternalStatusEnum(int index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public int getIndex(){
        return index;
    }
    public String getTypeName(){
        return typeName;
    }

    public static String getRightsInternalStatusName(int index){
    	return typeMap.get(index);
    }
}
