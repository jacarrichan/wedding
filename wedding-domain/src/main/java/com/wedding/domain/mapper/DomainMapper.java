package com.wedding.domain.mapper;

import com.wedding.domain.pojo.Domain;
import com.wedding.domain.pojo.DomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomainMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int countByExample(DomainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int deleteByExample(DomainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int insert(Domain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int insertSelective(Domain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    List<Domain> selectByExample(DomainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    Domain selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int updateByExampleSelective(@Param("record") Domain record, @Param("example") DomainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int updateByExample(@Param("record") Domain record, @Param("example") DomainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int updateByPrimaryKeySelective(Domain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_domain
     *
     * @mbggenerated Wed Oct 15 15:07:04 CST 2014
     */
    int updateByPrimaryKey(Domain record);
}