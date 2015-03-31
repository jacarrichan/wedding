package com.wedding.common.util;


import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils extends org.springframework.beans.BeanUtils {
	
	public static <T> T createBeanByTarget (Object obj, Class cls){
		Object target = null;
		try {
			target = cls.newInstance();
		} catch (Exception e) {
			
		}
		copyProperties(obj, target);
		return (T) target;
		
	}

    public static <T> List<T> createBeanListByTarget(List objects, Class cls){
        List<T> results = new ArrayList<T>();
        if(CollectionUtils.isEmpty(objects)){
            return results;
        }

        for(Object obj : objects){
            T t = createBeanByTarget(obj, cls);
            results.add(t);
        }
        return results;
    }

}
