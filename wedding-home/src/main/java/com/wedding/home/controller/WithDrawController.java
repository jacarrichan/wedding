package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.StringUtils;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.dto.WithDrawDto;
import com.wedding.order.pojo.Orders;
import com.wedding.order.service.OrderService;
import com.wedding.order.service.WithDrawService;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by chuweifeng on 14-9-29.
 */
@Controller
@RequestMapping(value="/withdraw")
public class WithDrawController {
    @Autowired
    private WithDrawService withDrawService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SellerService sellerService;

    /**
     * 用户查询自己的提现单据 并进行提现操作
     * **/
    @RequestMapping(value="/query.do")
    @ResponseBody
    public PageResult<WithDrawDto> query(WithDrawDto withDrawDto,HttpSession session,PageQuery pageQuery){
        PageResult<WithDrawDto> result = new PageResult<WithDrawDto>();
        String userId = (String)session.getAttribute(SessionConstants.USER_ID);
        if (!StringUtils.isEmpty(userId)) {
            withDrawDto.setUserAccountId(userId);
            result = withDrawService.query(withDrawDto,pageQuery);
        }
        return result;
    }
    /**
     * @param session
     * @param withDrawDto
     * 保存提现单据
     * **/
    @RequestMapping(value = "/save.do")
    @ResponseBody
    public RequestResult save(HttpSession session,WithDrawDto withDrawDto){
        RequestResult result = new RequestResult();
        boolean bo = withDrawService.saveWithDraw(withDrawDto);
        if(bo){
            result.setMessage("保存成功");
        }else{
            result.setMessage("保存失败");
        }
        result.setSuccess(bo);
        return result;
    }

    /**
     * @param session
     * @param withDrawDto
     * 进行提现操作 提现需要判断商家设置的提现状态
     * **/
    @RequestMapping(value = "/tixian.do")
    @ResponseBody
    public RequestResult tixian(HttpSession session,WithDrawDto withDrawDto){
        RequestResult result = new RequestResult();
        //查询商家设置的体现状态
        OrdersDto ordersDto = orderService.getOrderByNo(withDrawDto.getOrderId());//获取订单的状态
        if(ordersDto==null){
            result.setMessage("获取订单信息失败");
            return result;
        }
        SellerDto sellerDto = sellerService.querySellerByUserId(ordersDto.getSellerId());
        if(sellerDto==null){
            result.setMessage("获取用户信息失败");
            return result;
        }
        //加入状态一直则允许提现操作 处理提现需要登记用户的详细信息
        if(ordersDto.getOrderStatus().equals(sellerDto.getWithdraw())){
            result.setMessage("允许提现");
        }else{
            result.setMessage("不允许提现");
        }
        return result;
    }


}
