package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.StringUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.items.dto.ItemsDto;
import com.wedding.order.constants.*;
import com.wedding.order.dto.CanWithDrawOrderDto;
import com.wedding.order.dto.OrderItemsDto;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 14-9-15.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    /**
     * 提交订单功能
     * @param ordersDto
     * @return
     */
    @RequestMapping(value = "/buildOrder.do")
    @ResponseBody
    public RequestResult buildOrder(OrdersDto ordersDto,HttpSession session){
        String id = UUIDGenerator.getUUID();
        ordersDto.setOrderIsOnline(Byte.valueOf(OrderInternalTypeEnum.ORDER_INTERNAL_TYPE_ONLINE.getIndex()+""));
        ordersDto.setId(id);
        ordersDto.setPaymentStatus(Byte.valueOf(OrderPaymentStatusEnum.PAYMENT_FIRST.getIndex() + ""));
        ordersDto.setOrderNo(StringUtils.buildOrderNo());
        ordersDto.setSellerId(session.getAttribute(SessionConstants.SELLER_ID).toString());
        if(OrderTypeEnum.BRIDAL_ORDER.getIndex()==ordersDto.getOrderType()) {
            ordersDto.setOrderStatus(BridalOrderStatusEnum.ORDER_AGREED.name());
        }else if(OrderTypeEnum.HOTEL_ORDER.getIndex()==ordersDto.getOrderType()){
            ordersDto.setOrderStatus(HotelOrderStatusEnum.ORDER_AGREED.name());
        }else if(OrderTypeEnum.MARRY_ORDER.getIndex()==ordersDto.getOrderType()){
            ordersDto.setOrderStatus(MarryOrderStatusEnum.ORDER_AGREED.name());
        }else if(OrderTypeEnum.OTHER_ORDER.getIndex()==ordersDto.getOrderType()){
            ordersDto.setOrderStatus(OtherOrderStatusEnum.ORDER_AGREED.name());
        }else{
            throw new SystemException("系统未知订单类型");
        }
        // ordersDto.setBuyerMobileNo("18220818001");
        // ordersDto.setOrderTotal(1000000);
        // ordersDto.setAppointId("ce057ff3-7907-4d79-a885-7014a54ae180");
        // ordersDto.setOrderBuyerId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");
        ordersDto.setShopId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");

        List<OrderItemsDto> itemsDtoList = ordersDto.getOrderItemsDtoList();
        for(OrderItemsDto itemsDto : itemsDtoList){
            itemsDto.setOrderId(id);
        }
        /*OrderItemsDto orderItemsDto = new OrderItemsDto();
        orderItemsDto.setItemTotal(1000000);
        orderItemsDto.setDiscountFee(0);
        orderItemsDto.setItemName("结婚大礼包");
        orderItemsDto.setItemId("4eee09be-b9a2-4ce8-bfa0-fd9c81f8aa32");
        orderItemsDto.setOrderId(id);
        orderItemsDto.setQuantity(1);
        itemsDtoList.add(orderItemsDto);
        ordersDto.setOrderItemsDtoList(itemsDtoList);*/
        RequestResult result = new RequestResult();
        try {
            this.orderService.saveOrder(ordersDto);
            result.setSuccess(true);
            result.setMessage("订单生成成功！");
        }catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("调用发生异常"+ex.getMessage());
        }
        return result;
    }

    /**
     * 生成订单
     */
    private void build(){
        OrdersDto orderDto = new OrdersDto();
        orderDto.setOrderNo(StringUtils.buildOrderNo());

    }

    /**
     * 修改订单状态功能
     * @param orderNo
     * @param orderStatus
     * @return
     */
    @RequestMapping(value = "/updateOrderStatus.do")
    @ResponseBody
    public RequestResult updateOrderStatus(@RequestParam String orderNo,@RequestParam String orderStatus){
        RequestResult result = new RequestResult();
        try {
            OrdersDto ordersDto = this.orderService.getOrderByNo(orderNo);
            ordersDto.setOrderStatus(orderStatus);
            this.orderService.updateOrderStatus(ordersDto);
            result.setSuccess(true);
            result.setMessage("订单状态修改成功！");
        }catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("调用发生异常"+ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/query.do")
    @ResponseBody
    public PageResult<OrdersDto> queryOrder(PageQuery pageQuery,HttpSession session){
        String userId = (String)session.getAttribute(SessionConstants.USER_ID);
        PageResult<OrdersDto> resultList = new PageResult<OrdersDto>();
        if (!StringUtils.isEmpty(userId)) {
            resultList = orderService.getOrderListByUser(userId, pageQuery);
        }
        return resultList;
    }

    /**
     * 查询可提现的销售订单
     * @param pageQuery
     * @param session
     * @return
     */
    @RequestMapping(value = "/canWithDrawOrder.do")
    @ResponseBody
    public PageResult<CanWithDrawOrderDto> queryCanWithDrawOrder(PageQuery pageQuery,HttpSession session){
        String userId = (String)session.getAttribute(SessionConstants.USER_ID);
        PageResult<CanWithDrawOrderDto> resultList = new PageResult<CanWithDrawOrderDto>();
        if (!StringUtils.isEmpty(userId)) {
            resultList = orderService.getOrderListByUserAndSeller(userId, pageQuery);
        }
        return resultList;
    }

}
