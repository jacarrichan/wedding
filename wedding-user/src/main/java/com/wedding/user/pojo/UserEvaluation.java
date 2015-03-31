package com.wedding.user.pojo;



import java.util.Date;

/**
 * Created by zhua02 on 2015/1/12.
 */
public class UserEvaluation {

    private String id;


    private String shopId;


    private double priceEva;


    private double serviceEva;


    private double invisibleEva;


    private Date createTime;


    private String createPerson;


    private Date lastUpdateTime;

    private String lastUpdatePerson;


    private int stat;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public double getPriceEva() {
        return priceEva;
    }

    public void setPriceEva(double priceEva) {
        this.priceEva = priceEva;
    }

    public double getServiceEva() {
        return serviceEva;
    }

    public void setServiceEva(double serviceEva) {
        this.serviceEva = serviceEva;
    }

    public double getInvisibleEva() {
        return invisibleEva;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public void setInvisibleEva(double invisibleEva) {
        this.invisibleEva = invisibleEva;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    public void setLastUpdatePerson(String lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }


}
