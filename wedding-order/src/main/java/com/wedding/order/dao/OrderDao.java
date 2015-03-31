package com.wedding.order.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.order.dto.CanWithDrawOrderDto;
import com.wedding.order.mapper.OrderManageMapper;
import com.wedding.order.mapper.OrdersMapper;
import com.wedding.order.pojo.Orders;
import com.wedding.order.pojo.OrdersExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Peter on 14-9-15.
 */
@Repository
public class OrderDao extends MyBatisBaseDao<Orders> {

    @Getter
    @Autowired
    private OrdersMapper mapper;

    @Getter
    @Autowired
    private OrderManageMapper OMmapper;

    public void saveOrder(Orders orders){
        this.mapper.insert(orders);
    }

    public Orders getOrderbyNo(String orderNo){
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<Orders> ordersList = this.mapper.selectByExample(example);
        return CollectionUtils.isEmpty(ordersList) ? null : ordersList.get(0);
    }

    public void updateOrderStatus(Orders orders){
        OrdersExample example = new OrdersExample();
        this.mapper.updateByExample(orders,example);
    }

    public List<Orders> getOrderListByUser(String userId,PageQuery pageQuery){
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andStatEqualTo(DataStatus.ENABLED);
        criteria.andOrderBuyerIdEqualTo(userId);
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }

    public List<Orders> getOrderListBySeller(String sellerId,PageQuery pageQuery){
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andStatEqualTo(DataStatus.ENABLED);
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }

    public List<CanWithDrawOrderDto> getOrderListByUserAndSeller(String userId,PageQuery pageQuery){
        return this.OMmapper.findByUserAndSeller(userId,pageQuery);
    }

}
