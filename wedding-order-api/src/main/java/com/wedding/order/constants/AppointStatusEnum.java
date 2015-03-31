package com.wedding.order.constants;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Peter on 14-9-19.
 */
public enum AppointStatusEnum {

    APPOINT_STATUS_CREATED(1,"已创建"),

    APPOINT_STATUS_CANCELED(2,"已取消"),

    APPOINT_STATUS_FINISHED(3,"已完成");
    
    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();

    static{
    	for(AppointStatusEnum type : AppointStatusEnum.values()){
    		typeMap.put(type.getIndex(), type.getValue());
    	}
    }

    @Getter
    @Setter
    private int index;

    @Getter
    @Setter
    private String value;

    AppointStatusEnum(int index, String value) {
         this.index = index;
         this.value = value;
    }

    public static String getAppointStatusValue(int index){
    	return typeMap.get(index);
    }
}
