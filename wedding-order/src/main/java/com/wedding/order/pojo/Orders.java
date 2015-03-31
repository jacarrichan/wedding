package com.wedding.order.pojo;

import java.util.Date;

public class Orders {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.order_type
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Byte orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.order_no
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.order_total
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Integer orderTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.order_buyer_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String orderBuyerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.order_status
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String orderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.payment_status
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Byte paymentStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.appoint_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String appointId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.create_time
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.create_person
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String createPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.last_update_time
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.last_update_person
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String lastUpdatePerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.stat
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Integer stat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.order_is_online
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private Byte orderIsOnline;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.shop_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String shopId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.seller_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String sellerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_orders.buyer_mobile_no
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    private String buyerMobileNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.id
     *
     * @return the value of wd_orders.id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.id
     *
     * @param id the value for wd_orders.id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.order_type
     *
     * @return the value of wd_orders.order_type
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Byte getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.order_type
     *
     * @param orderType the value for wd_orders.order_type
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.order_no
     *
     * @return the value of wd_orders.order_no
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.order_no
     *
     * @param orderNo the value for wd_orders.order_no
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.order_total
     *
     * @return the value of wd_orders.order_total
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Integer getOrderTotal() {
        return orderTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.order_total
     *
     * @param orderTotal the value for wd_orders.order_total
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.order_buyer_id
     *
     * @return the value of wd_orders.order_buyer_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getOrderBuyerId() {
        return orderBuyerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.order_buyer_id
     *
     * @param orderBuyerId the value for wd_orders.order_buyer_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setOrderBuyerId(String orderBuyerId) {
        this.orderBuyerId = orderBuyerId == null ? null : orderBuyerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.order_status
     *
     * @return the value of wd_orders.order_status
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.order_status
     *
     * @param orderStatus the value for wd_orders.order_status
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.payment_status
     *
     * @return the value of wd_orders.payment_status
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.payment_status
     *
     * @param paymentStatus the value for wd_orders.payment_status
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.appoint_id
     *
     * @return the value of wd_orders.appoint_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getAppointId() {
        return appointId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.appoint_id
     *
     * @param appointId the value for wd_orders.appoint_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setAppointId(String appointId) {
        this.appointId = appointId == null ? null : appointId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.create_time
     *
     * @return the value of wd_orders.create_time
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.create_time
     *
     * @param createTime the value for wd_orders.create_time
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.create_person
     *
     * @return the value of wd_orders.create_person
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.create_person
     *
     * @param createPerson the value for wd_orders.create_person
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.last_update_time
     *
     * @return the value of wd_orders.last_update_time
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.last_update_time
     *
     * @param lastUpdateTime the value for wd_orders.last_update_time
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.last_update_person
     *
     * @return the value of wd_orders.last_update_person
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.last_update_person
     *
     * @param lastUpdatePerson the value for wd_orders.last_update_person
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setLastUpdatePerson(String lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson == null ? null : lastUpdatePerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.stat
     *
     * @return the value of wd_orders.stat
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.stat
     *
     * @param stat the value for wd_orders.stat
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.order_is_online
     *
     * @return the value of wd_orders.order_is_online
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public Byte getOrderIsOnline() {
        return orderIsOnline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.order_is_online
     *
     * @param orderIsOnline the value for wd_orders.order_is_online
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setOrderIsOnline(Byte orderIsOnline) {
        this.orderIsOnline = orderIsOnline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.shop_id
     *
     * @return the value of wd_orders.shop_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.shop_id
     *
     * @param shopId the value for wd_orders.shop_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.seller_id
     *
     * @return the value of wd_orders.seller_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.seller_id
     *
     * @param sellerId the value for wd_orders.seller_id
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_orders.buyer_mobile_no
     *
     * @return the value of wd_orders.buyer_mobile_no
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public String getBuyerMobileNo() {
        return buyerMobileNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_orders.buyer_mobile_no
     *
     * @param buyerMobileNo the value for wd_orders.buyer_mobile_no
     *
     * @mbggenerated Mon Sep 15 13:51:26 CST 2014
     */
    public void setBuyerMobileNo(String buyerMobileNo) {
        this.buyerMobileNo = buyerMobileNo == null ? null : buyerMobileNo.trim();
    }
}