package com.wedding.orders.test;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.StringUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.order.constants.*;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.OrderItemsDto;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.pojo.OrderItems;
import com.wedding.order.service.AppointService;
import com.wedding.order.service.OrderService;
import com.wedding.order.service.impl.AppointServiceImpl;
import com.wedding.order.service.impl.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 14-9-17.
 */
public class TestOrderService {

    static BeanFactory bf;

    @Before
    public void initBean() {

        bf = new ClassPathXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");

    }

    @Test
    public void saveOrder(){
        OrderService service =  (OrderService)bf.getBean("orderServiceImpl");
        OrdersDto ordersDto = new OrdersDto();
        String id = UUIDGenerator.getUUID();
        ordersDto.setOrderIsOnline(Byte.valueOf(OrderInternalTypeEnum.ORDER_INTERNAL_TYPE_ONLINE.getIndex()+""));
        ordersDto.setId(id);
        ordersDto.setPaymentStatus(Byte.valueOf(OrderPaymentStatusEnum.PAYMENT_FIRST.getIndex() + ""));
        ordersDto.setOrderNo(StringUtils.buildOrderNo());
        ordersDto.setSellerId("331cb9af-6c2d-4642-8809-3daee1e56fb4");
        ordersDto.setOrderType(Byte.valueOf(OrderTypeEnum.HOTEL_ORDER.getIndex() + ""));
        ordersDto.setOrderStatus(HotelOrderStatusEnum.ORDER_AGREED.getValue());
        ordersDto.setBuyerMobileNo("18220818001");
        ordersDto.setOrderTotal(1000000);
        ordersDto.setAppointId("ce057ff3-7907-4d79-a885-7014a54ae180");
        ordersDto.setOrderBuyerId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");
        ordersDto.setShopId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");
        List<OrderItemsDto> itemsDtoList = new ArrayList<OrderItemsDto>();
        OrderItemsDto orderItemsDto = new OrderItemsDto();
        orderItemsDto.setItemTotal(1000000);
        orderItemsDto.setDiscountFee(0);
        orderItemsDto.setItemName("结婚大礼包");
        orderItemsDto.setItemId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");
        orderItemsDto.setOrderId(id);
        orderItemsDto.setQuantity(1);
        itemsDtoList.add(orderItemsDto);
        ordersDto.setOrderItemsDtoList(itemsDtoList);
        service.saveOrder(ordersDto);
    }

    @Test
    public void getOrderByNo(){
        OrderService service =  (OrderService)bf.getBean("orderServiceImpl");
        OrdersDto dto = service.getOrderByNo("20140918434");
        System.out.println(dto.getId());
    }


}
