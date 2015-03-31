package com.wedding.order.service.impl;

import com.wedding.common.util.BeanUtils;
import com.wedding.order.dao.OrderItemsDao;
import com.wedding.order.dto.OrderItemsDto;
import com.wedding.order.pojo.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 14-9-20.
 */
@Service
public class OrderItemServiceImpl implements com.wedding.order.service.OrderItemService {

    @Autowired
    private OrderItemsDao orderItemsDao;

    @Override
    public List<OrderItemsDto> getOrderItemsByOrderId(String orderId){
        List<OrderItems> orderItems = this.orderItemsDao.getOrderItemsByOrderId(orderId);
        List<OrderItemsDto> orderItemsDtos = new ArrayList<OrderItemsDto>();
        for(OrderItems items : orderItems){
            OrderItemsDto orderItemsDto = new OrderItemsDto();
            BeanUtils.copyProperties(items,orderItems);
            orderItemsDtos.add(orderItemsDto);
        }
        return  orderItemsDtos;
    }

}
