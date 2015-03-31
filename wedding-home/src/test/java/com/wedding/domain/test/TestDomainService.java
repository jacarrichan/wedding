package com.wedding.domain.test;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.domain.dto.DomainDto;
import com.wedding.domain.service.DomainService;
import com.wedding.domain.service.DomainServiceImpl;
import com.wedding.order.constants.AppointStatusEnum;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.service.AppointService;
import com.wedding.order.service.impl.AppointServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Peter on 14-9-17.
 */
public class TestDomainService {

    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }

    @Test
    public void saveDomain(){
        DomainService domainService = bf.getBean("domainServiceImpl",DomainServiceImpl.class);
        DomainDto domainDto = new DomainDto();
        domainDto.setDomainName("温馨婚庆公司");
        domainDto.setDomain("wxhq.juxiwang.com");
        domainService.saveDomain(domainDto);
    }


}
