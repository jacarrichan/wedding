package com.wedding.utils.test;

import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.service.SellerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by arroganter on 14-9-17.
 */
public class TestSeller {
    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }
    @Test
    public void addSeller(){
        Date date=new Date();
        SellerServiceImpl sellerServiceImpl =  bf.getBean(SellerServiceImpl.class);
//        SellerDto sd=new SellerDto();
//        sd.setName("test");
//        sd.setAddress("五角场");
//        sd.setType((byte) 1);
//        sd.setParentId("test");
//        sd.setLevel(1);
//        sd.setLinsence("d://");
//        sd.setIdCardA("321");
//        sd.setIdCardB("139");
//        sd.setStartTime(date);
//        sd.setEndTime(date);
        ShopDto shopdto=new ShopDto();
        shopdto.setName("test");
        shopdto.setLogo("logo");
        shopdto.setSellerId("testtest");
        sellerServiceImpl.addShop(shopdto);

//        int jg=sellerServiceImpl.addSeller(sd);
//        System.out.println(jg);
    }
}
