package com.wedding.order.service.impl;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.order.dao.OrderDao;
import com.wedding.order.dao.OrderItemsDao;
import com.wedding.order.dto.CanWithDrawOrderDto;
import com.wedding.order.dto.OrderItemsDto;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.pojo.OrderItems;
import com.wedding.order.pojo.Orders;
import com.wedding.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 14-9-15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemsDao orderItemsDao;

    @Transactional
    @Override
    public void saveOrder(OrdersDto ordersDto) {
        // 保存单头
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersDto, orders);
        this.orderDao.insert(orders);
        for(OrderItemsDto orderItemsDto : ordersDto.getOrderItemsDtoList()){
            OrderItems orderItem = new OrderItems();
            BeanUtils.copyProperties(orderItemsDto,orderItem);
            this.orderItemsDao.insert(orderItem);
        }
    }

    @Transactional
    @Override
    public void updateOrderStatus(OrdersDto ordersDto) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersDto,orders);
        this.orderDao.updateOrderStatus(orders);
    }

    @Override
    public OrdersDto getOrderByNo(String orderNo) {
        Orders orders =  this.orderDao.getOrderbyNo(orderNo);
        if(orders==null){
            return null;
        }
        OrdersDto ordersDto = new OrdersDto();
        BeanUtils.copyProperties(orders,ordersDto);
        return ordersDto;
    }

    @Override
    public PageResult<OrdersDto> getOrderListByUser(String userId,PageQuery pageQuery) {
        List<Orders> orderList = this.orderDao.getOrderListByUser(userId,pageQuery);
        List<OrdersDto> ordersDtoList = new ArrayList<OrdersDto>();
        for(Orders order : orderList){
            OrdersDto ordersDto = new OrdersDto();
            BeanUtils.copyProperties(order,ordersDto);
            ordersDtoList.add(ordersDto);
        }
        return new PageResult<OrdersDto>(pageQuery,ordersDtoList);
    }

    @Override
    public PageResult<OrdersDto> getOrderListBySeller(String sellerId,PageQuery pageQuery) {
        List<Orders> orderList = this.orderDao.getOrderListBySeller(sellerId,pageQuery);
        List<OrdersDto> ordersDtoList = new ArrayList<OrdersDto>();
        for(Orders order : orderList){
            OrdersDto ordersDto = new OrdersDto();
            BeanUtils.copyProperties(order,ordersDto);
            ordersDtoList.add(ordersDto);
        }
        return new PageResult<OrdersDto>(pageQuery,ordersDtoList);
    }

    @Override
    public PageResult<CanWithDrawOrderDto> getOrderListByUserAndSeller(String userId,PageQuery pageQuery){
        List<CanWithDrawOrderDto> canWithDrawOrderDtoList = this.orderDao.getOrderListByUserAndSeller(userId, pageQuery);
        return new PageResult<CanWithDrawOrderDto>(pageQuery,canWithDrawOrderDtoList);
    }
}
