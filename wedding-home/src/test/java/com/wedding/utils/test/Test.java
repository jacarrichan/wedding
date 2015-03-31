package com.wedding.utils.test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.wedding.common.util.JsonUtil;
import com.wedding.seller.dto.ShopDto;

public class Test {

	 public static void main(String args[]){
         List<ShopDto> list = new ArrayList<ShopDto>();
         ShopDto shopDto = new ShopDto();
         shopDto.setName("123");
         shopDto.setCreatePerson("fsdaf");
         list.add(shopDto);

         shopDto = new ShopDto();
         shopDto.setName("234");
         shopDto.setCreatePerson("adfas");
         list.add(shopDto);

         Gson gson = new Gson();
         String a = gson.toJson(list);
         System.out.println(a);
       
         Type type = new TypeToken<List<ShopDto>>(){}.getType();
         List<ShopDto> result = JsonUtil.getObjFromJsonArray(a, type);
         for(ShopDto dto : result) {
        	  System.out.println(dto);
         }
     }
}
