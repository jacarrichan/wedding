package com.wedding.user.mapper;

import com.wedding.user.dto.RightsCenterDto;
import com.wedding.user.pojo.RightsCenter;
import com.wedding.user.pojo.RightsCenterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RightsCenterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int countByExample(RightsCenterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int deleteByExample(RightsCenterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int insert(RightsCenter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int insertSelective(RightsCenter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    List<RightsCenter> selectByExample(RightsCenterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    RightsCenter selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int updateByExampleSelective(@Param("record") RightsCenter record, @Param("example") RightsCenterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int updateByExample(@Param("record") RightsCenter record, @Param("example") RightsCenterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int updateByPrimaryKeySelective(RightsCenter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_rights_center
     *
     * @mbggenerated Sun Oct 05 20:18:29 CST 2014
     */
    int updateByPrimaryKey(RightsCenter record);
    List<RightsCenterDto> findRightById(@Param("dateWeek") String dateWeek,@Param("dateMonth") String dateMonth,@Param("currNum") String currNum,@Param("pageCount") String pageCount,@Param("sellerName") String sellerName);
    String findSellerName(@Param("userId") String userId);
    void revoke(@Param("ids") String ids);
    Integer countBeingProcess(@Param("dateWeek") String dateWeek,@Param("dateMonth") String dateMonth,@Param("sellerName") String sellerName);
    Integer countFinish(@Param("dateWeek") String dateWeek,@Param("dateMonth") String dateMonth,@Param("sellerName") String sellerName);
    Integer countSurvey(@Param("dateWeek") String dateWeek,@Param("dateMonth") String dateMonth,@Param("sellerName") String sellerName);

}