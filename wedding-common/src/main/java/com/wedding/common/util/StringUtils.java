
package com.wedding.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;


/**
 * @author rkzhang
 *
 */
public abstract class StringUtils extends org.apache.commons.lang.StringUtils{

    /**
     * 订单生成格式
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String buildOrderNo(){
        return sdf.format(new Date());
    }

	public static List<byte[]> splitString(String data, int len){
		byte[] all = data.getBytes();
		List<byte[]> list = new ArrayList<byte[]>();
		for(int i = 0; i < all.length; i = i + len){
			int end = i + len;
			if(end >= all.length){
				end = all.length;
			}
			byte[] temp = ArrayUtils.subarray(all, i, end);
			list.add(temp);
			
		}
		return list;
	}
	
	
}
