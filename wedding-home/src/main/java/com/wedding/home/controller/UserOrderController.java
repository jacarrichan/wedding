package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.service.OrderItemService;
import com.wedding.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Peter on 14-9-20.
 */
@Controller
@RequestMapping("/user/orders")
public class UserOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/getOrders.do")
    @ResponseBody
    public PageResult<OrdersDto> getOrders(HttpSession session,PageQuery pageQuery){
        String userId = session.getAttribute(SessionConstants.USER_ID).toString();
        PageResult<OrdersDto> pageResult =  this.orderService.getOrderListByUser(userId, pageQuery);
        for(OrdersDto ordersDto : pageResult.getResults()){
            ordersDto.setOrderItemsDtoList(this.orderItemService.getOrderItemsByOrderId(ordersDto.getId()));
        }
        return pageResult;
    }
}
