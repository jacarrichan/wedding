package com.wedding.rights.test;

import com.wedding.user.constants.RightsCenterEnum;
import com.wedding.user.dto.RightsCenterDto;
import com.wedding.user.dto.UserFavoriteDto;
import com.wedding.user.service.RightsCenterService;
import com.wedding.user.service.UserFavoriteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arroganter on 14-9-17.
 */
public class TestRightsCenter {
    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }
    @Test
    public void save(){
        RightsCenterService service = (RightsCenterService) bf.getBean("rightsCenterServiceImpl");
        RightsCenterDto rightsCenterDto = new RightsCenterDto();
        rightsCenterDto.setUserAccountId("1212121");
        rightsCenterDto.setContent("虚假信息举报");
        rightsCenterDto.setType(RightsCenterEnum.VIRTUAL_INFO.getIndex());
        rightsCenterDto.setContactInfo("18220818001");
        rightsCenterDto.setSellerName("悲哀公司");
        rightsCenterDto.setUserAccountId("12ooooooooo");
        service.save(rightsCenterDto);
    }
}
