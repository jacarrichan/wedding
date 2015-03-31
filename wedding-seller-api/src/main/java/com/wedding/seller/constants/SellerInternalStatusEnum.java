package com.wedding.seller.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 14-10-10.
 */
public enum SellerInternalStatusEnum {

    APPLY_PROCESSING(1,"待审核"),

    APPLY_SUCCESS(2,"审核成功"),

    APPLY_NO_SUCCESS(3,"审核未通过"),

    APPLY_BEING_PROCESS(4,"正在处理"),
    APPLY_REVOKE(5,"撤销");

    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(SellerInternalStatusEnum type : SellerInternalStatusEnum.values()){
    		typeMap.put(type.getIndex(), type.getTypeName());
    	}
    }

    private int index;

    private String typeName;

    SellerInternalStatusEnum(int index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public int getIndex(){
        return index;
    }
    public String getTypeName(){
        return typeName;
    }

    public static String getSellerInternalStatusName(int index){
    	return typeMap.get(index);
    }
}
