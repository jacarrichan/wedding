package com.wedding.admin.manager.mapper;

import com.wedding.admin.manager.pojo.Action;
import com.wedding.admin.manager.pojo.ActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int countByExample(ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int deleteByExample(ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int insert(Action record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int insertSelective(Action record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    List<Action> selectByExample(ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    Action selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int updateByExampleSelective(@Param("record") Action record, @Param("example") ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int updateByExample(@Param("record") Action record, @Param("example") ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int updateByPrimaryKeySelective(Action record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_action
     *
     * @mbggenerated Fri Aug 29 17:07:17 CST 2014
     */
    int updateByPrimaryKey(Action record);
}