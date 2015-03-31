package com.wedding.addresses.test;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.constants.AppointStatusEnum;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.service.AppointService;
import com.wedding.order.service.impl.AppointServiceImpl;
import com.wedding.tools.dao.AddressesViewDao;
import com.wedding.tools.pojo.AddressesView;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Peter on 14-9-17.
 */
public class TestAddressQueryView {

    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }

    @Test
    public void getAddressByStr(){
        AddressesViewDao dao = (AddressesViewDao)bf.getBean("addressesViewDao");
        List<AddressesView> list =  dao.getAddressByStr("新疆哈密市");
        System.out.println(list.size());
    }

}
