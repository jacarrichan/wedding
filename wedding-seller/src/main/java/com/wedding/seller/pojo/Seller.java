package com.wedding.seller.pojo;

import java.util.Date;

public class Seller {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.name
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.province_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Integer provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.city_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Integer cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.region_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Integer regionCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.address
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.create_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.type
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Byte type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.parent_id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.internal_status
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Integer internalStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.level
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.linsence
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String linsence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.build_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Date buildTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.domain_id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String domainId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.org_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String orgCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.id_card_a
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String idCardA;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.id_card_b
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String idCardB;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.logo
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String logo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.start_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.end_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.withdraw
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Byte withdraw;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.create_person
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String createPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.last_update_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.last_update_person
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private String lastUpdatePerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wd_seller.stat
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.id
     *
     * @return the value of wd_seller.id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.id
     *
     * @param id the value for wd_seller.id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.name
     *
     * @return the value of wd_seller.name
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.name
     *
     * @param name the value for wd_seller.name
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.province_code
     *
     * @return the value of wd_seller.province_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Integer getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.province_code
     *
     * @param provinceCode the value for wd_seller.province_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.city_code
     *
     * @return the value of wd_seller.city_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.city_code
     *
     * @param cityCode the value for wd_seller.city_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.region_code
     *
     * @return the value of wd_seller.region_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Integer getRegionCode() {
        return regionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.region_code
     *
     * @param regionCode the value for wd_seller.region_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.address
     *
     * @return the value of wd_seller.address
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.address
     *
     * @param address the value for wd_seller.address
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.create_time
     *
     * @return the value of wd_seller.create_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.create_time
     *
     * @param createTime the value for wd_seller.create_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.type
     *
     * @return the value of wd_seller.type
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.type
     *
     * @param type the value for wd_seller.type
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.parent_id
     *
     * @return the value of wd_seller.parent_id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.parent_id
     *
     * @param parentId the value for wd_seller.parent_id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.internal_status
     *
     * @return the value of wd_seller.internal_status
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Integer getInternalStatus() {
        return internalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.internal_status
     *
     * @param internalStatus the value for wd_seller.internal_status
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setInternalStatus(Integer internalStatus) {
        this.internalStatus = internalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.level
     *
     * @return the value of wd_seller.level
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.level
     *
     * @param level the value for wd_seller.level
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.linsence
     *
     * @return the value of wd_seller.linsence
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getLinsence() {
        return linsence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.linsence
     *
     * @param linsence the value for wd_seller.linsence
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setLinsence(String linsence) {
        this.linsence = linsence == null ? null : linsence.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.build_time
     *
     * @return the value of wd_seller.build_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Date getBuildTime() {
        return buildTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.build_time
     *
     * @param buildTime the value for wd_seller.build_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.domain_id
     *
     * @return the value of wd_seller.domain_id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.domain_id
     *
     * @param domainId the value for wd_seller.domain_id
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setDomainId(String domainId) {
        this.domainId = domainId == null ? null : domainId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.org_code
     *
     * @return the value of wd_seller.org_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.org_code
     *
     * @param orgCode the value for wd_seller.org_code
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.id_card_a
     *
     * @return the value of wd_seller.id_card_a
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getIdCardA() {
        return idCardA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.id_card_a
     *
     * @param idCardA the value for wd_seller.id_card_a
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setIdCardA(String idCardA) {
        this.idCardA = idCardA == null ? null : idCardA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.id_card_b
     *
     * @return the value of wd_seller.id_card_b
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getIdCardB() {
        return idCardB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.id_card_b
     *
     * @param idCardB the value for wd_seller.id_card_b
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setIdCardB(String idCardB) {
        this.idCardB = idCardB == null ? null : idCardB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.logo
     *
     * @return the value of wd_seller.logo
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getLogo() {
        return logo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.logo
     *
     * @param logo the value for wd_seller.logo
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.start_time
     *
     * @return the value of wd_seller.start_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.start_time
     *
     * @param startTime the value for wd_seller.start_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.end_time
     *
     * @return the value of wd_seller.end_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.end_time
     *
     * @param endTime the value for wd_seller.end_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.withdraw
     *
     * @return the value of wd_seller.withdraw
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Byte getWithdraw() {
        return withdraw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.withdraw
     *
     * @param withdraw the value for wd_seller.withdraw
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setWithdraw(Byte withdraw) {
        this.withdraw = withdraw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.create_person
     *
     * @return the value of wd_seller.create_person
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.create_person
     *
     * @param createPerson the value for wd_seller.create_person
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.last_update_time
     *
     * @return the value of wd_seller.last_update_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.last_update_time
     *
     * @param lastUpdateTime the value for wd_seller.last_update_time
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.last_update_person
     *
     * @return the value of wd_seller.last_update_person
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public String getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.last_update_person
     *
     * @param lastUpdatePerson the value for wd_seller.last_update_person
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setLastUpdatePerson(String lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson == null ? null : lastUpdatePerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wd_seller.stat
     *
     * @return the value of wd_seller.stat
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wd_seller.stat
     *
     * @param stat the value for wd_seller.stat
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}