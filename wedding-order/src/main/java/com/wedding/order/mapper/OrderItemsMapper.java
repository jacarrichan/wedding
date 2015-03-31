package com.wedding.order.mapper;

import com.wedding.order.pojo.OrderItems;
import com.wedding.order.pojo.OrderItemsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int countByExample(OrderItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int deleteByExample(OrderItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int insert(OrderItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int insertSelective(OrderItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    List<OrderItems> selectByExample(OrderItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    OrderItems selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int updateByExampleSelective(@Param("record") OrderItems record, @Param("example") OrderItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int updateByExample(@Param("record") OrderItems record, @Param("example") OrderItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int updateByPrimaryKeySelective(OrderItems record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_order_items
     *
     * @mbggenerated Fri Sep 19 10:45:17 CST 2014
     */
    int updateByPrimaryKey(OrderItems record);
}