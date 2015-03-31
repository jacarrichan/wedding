package com.wedding.order.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.order.mapper.OrderItemsMapper;
import com.wedding.order.mapper.OrdersMapper;
import com.wedding.order.pojo.OrderItems;
import com.wedding.order.pojo.OrderItemsExample;
import com.wedding.order.pojo.Orders;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-9-15.
 */
@Repository
public class OrderItemsDao extends MyBatisBaseDao<OrderItems> {

    @Getter
    @Autowired
    private OrderItemsMapper mapper;

    public List<OrderItems> getOrderItemsByOrderId(String orderId){
        OrderItemsExample example = new OrderItemsExample();
        OrderItemsExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        criteria.andStatEqualTo(DataStatus.ENABLED);
        return this.mapper.selectByExample(example);
    }

}
