package com.wedding.seller.test;

import com.wedding.common.util.DateUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.seller.constants.SellerTypeEnum;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerProfileDto;
import com.wedding.seller.dto.ShopSiteIndexDto;
import com.wedding.seller.service.SellerProfileService;
import com.wedding.seller.service.SellerService;
import com.wedding.seller.service.SellerServiceImpl;
import com.wedding.seller.service.ShopSiteService;
import com.wedding.user.constants.RightsCenterEnum;
import com.wedding.user.dto.RightsCenterDto;
import com.wedding.user.service.RightsCenterService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Peter on 14-10-10.
 */
public class TestSellerProfileService {

    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }
    @Test
    public void save(){
        SellerProfileService service = (SellerProfileService) bf.getBean("sellerProfileServiceImpl");
        SellerProfileDto sellerProfileDto = new SellerProfileDto();
        sellerProfileDto.setScore(100);
        service.save(sellerProfileDto);
    }

    @Test
    public void getShopSiteByDomain(){
        ShopSiteService service =  (ShopSiteService)bf.getBean("shopSiteServiceImpl");
        ShopSiteIndexDto shopSiteIndexDto = service.loadShopByDomain("wxhq.juxiwang.com");
        System.out.println(shopSiteIndexDto.getShopName());
    }

    @Test
    public void sellerRegister(){
        SellerService service =  (SellerService)bf.getBean("sellerServiceImpl");
        SellerDto sellerDto = new SellerDto();
        sellerDto.setId(UUIDGenerator.getUUID());
        sellerDto.setName("看中彩虹，吃定彩虹！");
        sellerDto.setAddress("上海国定路335号");
        sellerDto.setBuildTime(DateUtils.parse("2010-10-12", "yyyy-MM-dd"));
        sellerDto.setProvinceCode(10010);
        sellerDto.setCityCode(10011);
        sellerDto.setRegionCode(10111);
        sellerDto.setType(Byte.valueOf(SellerTypeEnum.WEDDING_TYPE.getIndex() + ""));
        sellerDto.setIdCardA("c:/a.jpg");
        sellerDto.setIdCardB("c:/b.jpg");
        sellerDto.setLinsence("c:/linsence");
        sellerDto.setLogo("c:/logo.jpg");
        sellerDto.setLevel(1);
        sellerDto.setStartTime(DateUtils.parse("09:00", "HH:mm"));
        sellerDto.setEndTime(DateUtils.parse("18:00", "HH:mm"));
        service.registerSeller(sellerDto);
    }
}
