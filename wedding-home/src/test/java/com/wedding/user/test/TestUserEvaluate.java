package com.wedding.user.test;

import com.wedding.user.constants.UserEvaluateEnum;
import com.wedding.user.dto.UserEvaluateDto;
import com.wedding.user.dto.UserFavoriteDto;
import com.wedding.user.pojo.UserEvaluate;
import com.wedding.user.service.UserEvaluateService;
import com.wedding.user.service.UserFavoriteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arroganter on 14-9-17.
 */
public class TestUserEvaluate {
    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }
    @Test
    public void save(){
        UserEvaluateService service = (UserEvaluateService)bf.getBean("userEvaluateServiceImpl");
        UserEvaluateDto userEvaluateDto = new UserEvaluateDto();
        userEvaluateDto.setType(UserEvaluateEnum.APPOINT_EVAL.getIndex());
        userEvaluateDto.setUserId("0000000000");
        userEvaluateDto.setServiceQuota(2);
        userEvaluateDto.setEnvQuota(4);
        userEvaluateDto.setFunPriceQuota(4);
        userEvaluateDto.setSellerId("999999999");
        service.save(userEvaluateDto);
    }
}
