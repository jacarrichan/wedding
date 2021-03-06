package com.wedding.admin.manager.pojo;

import java.util.Date;

public class AccountAction {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.account_id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private String accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.action_id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private String actionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.create_time
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.create_person
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private String createPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.last_update_time
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.last_update_person
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private String lastUpdatePerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_account_action.stat
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.id
     *
     * @return the value of admin_account_action.id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.id
     *
     * @param id the value for admin_account_action.id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.account_id
     *
     * @return the value of admin_account_action.account_id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.account_id
     *
     * @param accountId the value for admin_account_action.account_id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.action_id
     *
     * @return the value of admin_account_action.action_id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.action_id
     *
     * @param actionId the value for admin_account_action.action_id
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setActionId(String actionId) {
        this.actionId = actionId == null ? null : actionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.create_time
     *
     * @return the value of admin_account_action.create_time
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.create_time
     *
     * @param createTime the value for admin_account_action.create_time
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.create_person
     *
     * @return the value of admin_account_action.create_person
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.create_person
     *
     * @param createPerson the value for admin_account_action.create_person
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.last_update_time
     *
     * @return the value of admin_account_action.last_update_time
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.last_update_time
     *
     * @param lastUpdateTime the value for admin_account_action.last_update_time
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.last_update_person
     *
     * @return the value of admin_account_action.last_update_person
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public String getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.last_update_person
     *
     * @param lastUpdatePerson the value for admin_account_action.last_update_person
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setLastUpdatePerson(String lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson == null ? null : lastUpdatePerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_account_action.stat
     *
     * @return the value of admin_account_action.stat
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_account_action.stat
     *
     * @param stat the value for admin_account_action.stat
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}