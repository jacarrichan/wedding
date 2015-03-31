package com.wedding.seller.test;

import com.wedding.common.util.DateUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.items.dto.ItemsDescDto;
import com.wedding.items.service.ItemsDescService;
import com.wedding.items.service.impl.ItemsDescServiceImpl;
import com.wedding.seller.constants.SellerTypeEnum;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerProfileDto;
import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.service.SellerProfileService;
import com.wedding.seller.service.SellerService;
import com.wedding.seller.service.ShopSiteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Peter on 14-10-10.
 */
public class TestItemsDescService {

    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }
    @Test
    public void save(){
        ItemsDescService service =  bf.getBean("itemsDescServiceImpl", ItemsDescServiceImpl.class);
        List<ItemsDescDto> itemsDescDto = service.getItemsDescByItemId("da58948a-904f-4dff-badf-a27c22a27de6");
        System.out.println("end");
    }
}
