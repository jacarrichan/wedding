package com.wedding.order.service;

import com.wedding.order.dto.OrderItemsDto;

import java.util.List;

/**
 * Created by Peter on 14-9-20.
 */
public interface OrderItemService {

    List<OrderItemsDto> getOrderItemsByOrderId(String orderId);
}
