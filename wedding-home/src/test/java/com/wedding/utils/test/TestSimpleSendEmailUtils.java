package com.wedding.utils.test;

import com.wedding.common.digest.MD5Coder;
import com.wedding.common.util.SimpleSendEmailUtils;
import com.wedding.common.util.SpringMailMessage;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Peter on 14-9-17.
 */
public class TestSimpleSendEmailUtils {

    static BeanFactory bf;

    @Before
    public void initBean(){

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }
    @Test
    public void getPasswod() throws Exception{
        String value = MD5Coder.encodeMD5Hex("123456");
        System.out.println(value);

    }
    @Test
    public void say() throws Exception{
        System.out.println("1");
       SimpleSendEmailUtils utils =  bf.getBean(SimpleSendEmailUtils.class);
        SpringMailMessage sms = new SpringMailMessage();
        sms.setFrom("13402136582@126.com");
        sms.setSubject("this is a test");
        sms.setText("Hello");
        sms.setTo("743107588@qq.com");
        utils.sendHtmlEmail(sms,"forget_password.ftl");

    }
}
