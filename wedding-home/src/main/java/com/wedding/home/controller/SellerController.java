package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.JsonUtil;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.service.ItemsService;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.service.AppointService;
import com.wedding.order.service.OrderItemService;
import com.wedding.order.service.OrderService;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.service.SellerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by chuweifeng on 14-9-15.update by Arro on 14-9-16
 */
@Controller
@RequestMapping(value="/seller")
@Log
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @Autowired
    private AppointService appointService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ItemsService itemService;

    /**
     * 获取预约列表
     * @param session
     * @param pageQuery
     * @return
     */
    @RequestMapping(value = "/appoints/list.do")
    @ResponseBody
    public PageResult<AppointDto> getAppoints(HttpSession session,PageQuery pageQuery){
       String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
        return this.appointService.getAppointsBySeller(sellerId,pageQuery);
    }

    /**
     * 获取订单列表
     * @param session
     * @param pageQuery
     * @return
     */
    @RequestMapping(value = "/orders/getOrders.do")
    @ResponseBody
    public PageResult<OrdersDto> getOrders(HttpSession session,PageQuery pageQuery){
        String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
        PageResult<OrdersDto> pageResult =  this.orderService.getOrderListBySeller(sellerId, pageQuery);
        for(OrdersDto ordersDto : pageResult.getResults()){
            ordersDto.setOrderItemsDtoList(this.orderItemService.getOrderItemsByOrderId(ordersDto.getId()));
        }
        return pageResult;
    }

    /**
     * 商家入驻功能
     * @param session
     * @param sellerDto
     * @return
     */
    @RequestMapping(value="/register.do")
    @ResponseBody
    public RequestResult register(HttpSession session, SellerDto sellerDto) {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        RequestResult requestResult = new RequestResult();
        try {
            if(sellerDto.getStartTime()==null){
                sellerDto.setStartTime(formatter.parse("9:00:00"));
            }
            if(sellerDto.getEndTime()==null){
                sellerDto.setEndTime(formatter.parse("18:00:00"));
            }
          String ids=  this.sellerService.registerSeller(sellerDto);

            //商家默认已登陆
            session.setAttribute(SessionConstants.SELLER_ID,ids);

            requestResult.setMessage("商家入驻信息保存成功");
            requestResult.setSuccess(true);
            return requestResult;
        }catch (Exception e){
            throw new SystemException("系统异常");
        }


    }

     /*
    * 店铺功能
    * */

    @RequestMapping(value="/addShop.do")
    @ResponseBody
    public String addShop(HttpSession session, ShopDto shopDto) {
        int result=sellerService.addShop(shopDto);
        if (result>0){
            return JsonUtil.getJsonStr(new RequestResult(true, "店铺保存成功"));
        }
        return JsonUtil.getJsonStr(new RequestResult(false, "店铺保存失败"));
    }

     /*
    * 发布商品
    * */

    @RequestMapping(value="/sendItem.do")
    @ResponseBody
    public SellerDto sendItem(HttpSession session) {
        String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
        return this.sellerService.querySellerByUserId(sellerId);
    }

      /*
    * 新增商品
    * */

    @RequestMapping(value="/addItem.do")
    @ResponseBody
    public RequestResult addItem(HttpSession session, ItemsDto itemsDto) {
        try {
            itemService.addItem(itemsDto);
        }catch (Exception ex){
            return new RequestResult(false,"保存商品失败");
        }
        return new RequestResult(true,"保存商品成功");
    }


}
