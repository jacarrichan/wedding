package com.wedding.orders.test;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
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
public class TestAppiontService {

    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }

    @Test
    public void getAppointsByUser(){
        AppointService service =  bf.getBean(AppointServiceImpl.class);
        PageQuery pageQuery = new PageQuery(1,5);
        PageResult<AppointDto> result = service.getAppointsByUser("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32", pageQuery);
        System.out.println(result.getTotal());
    }

    @Test
    public void getAppointsBySeller(){
        AppointService service =  bf.getBean(AppointServiceImpl.class);
        PageQuery pageQuery = new PageQuery(1,5);
        PageResult<AppointDto> result = service.getAppointsBySeller("331cb9af-6c2d-4642-8809-3daee1e56fb4", pageQuery);
        System.out.println(result.getTotal());
    }

    @Test
    public void updateStatus() throws Exception{
        AppointService service =  bf.getBean(AppointServiceImpl.class);
        AppointDto appointDto = service.getAppointById("ce057ff3-7907-4d79-a885-7014a54ae180");
        appointDto.setAppointStatus(Byte.valueOf(AppointStatusEnum.APPOINT_STATUS_CANCELED.getIndex()+""));
        service.updateStatus(appointDto);
    }

    @Test
    public void saveAppoint() throws Exception{
        AppointService service =  bf.getBean(AppointServiceImpl.class);
        AppointDto appointDto = new AppointDto();
        appointDto.setSellerId("331cb9af-6c2d-4642-8809-3daee1e56fb4");
        appointDto.setUserId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");
        appointDto.setMemo("我来看看你们这边的服务项目");
        appointDto.setAppointStatus(Byte.valueOf(AppointStatusEnum.APPOINT_STATUS_CREATED.getIndex()+""));
        service.saveAppoint(appointDto);
    }
}
