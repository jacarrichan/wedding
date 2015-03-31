package com.wedding.seller.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arroganter on 14-10-10.
 */
public enum SellerTypeEnum {

    WEDDING_TYPE(1,"婚庆服务"),
    HOTEL_TYPE(2,"酒店"),
    PHOTOGRAPHY_TYPE(3,"婚纱摄影"),
    JEWELRY_TYPE(4,"珠宝首饰"),
    DRESSES_TYPE(5,"婚纱礼服");
    
    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(SellerTypeEnum type : SellerTypeEnum.values()){
    		typeMap.put(type.getIndex(), type.getTypeName());
    	}
    }
    
    private int index;

    private String typeName;

    SellerTypeEnum(int index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public int getIndex(){
        return index;
    }
    public String getTypeName(){
        return typeName;
    }

    
    public static String getSellerTypeName(int index){
    	return typeMap.get(index);
    }
}
