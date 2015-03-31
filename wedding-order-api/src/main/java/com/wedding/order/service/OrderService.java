package com.wedding.order.service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.constants.OrderTypeEnum;
import com.wedding.order.dto.CanWithDrawOrderDto;
import com.wedding.order.dto.OrderItemsDto;
import com.wedding.order.dto.OrdersDto;

import java.util.List;

/**
 * Created by Peter on 14-9-15.
 */
public interface OrderService {

    /**
     * 保存订单
     * @param ordersDto
     */
    public void saveOrder(OrdersDto ordersDto);


        /**
         * 更改订单状态
         * @param ordersDto
         */
    void updateOrderStatus(OrdersDto ordersDto);

    /**
     * 获取订单by单号
     * @return
     */
    OrdersDto getOrderByNo(String orderNo);

    /**
     * 查询订单列表By用户
     * @param userId
     * @return
     */
    PageResult<OrdersDto> getOrderListByUser(String userId,PageQuery pageQuery);


    /**
     * 查询订单列表By商家
     * @param sellerId
     * @return
     */
    PageResult<OrdersDto> getOrderListBySeller(String sellerId,PageQuery pageQuery);

    /**
     * 可提返现订单查询
     * @param userId
     * @return
     */
    PageResult<CanWithDrawOrderDto> getOrderListByUserAndSeller(String userId,PageQuery pageQuery);
}
