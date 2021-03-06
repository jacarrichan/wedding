package com.wedding.tools.mapper;

import com.wedding.tools.pojo.Addresses;
import com.wedding.tools.pojo.AddressesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int countByExample(AddressesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int deleteByExample(AddressesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int insert(Addresses record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int insertSelective(Addresses record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    List<Addresses> selectByExample(AddressesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    Addresses selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int updateByExampleSelective(@Param("record") Addresses record, @Param("example") AddressesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int updateByExample(@Param("record") Addresses record, @Param("example") AddressesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int updateByPrimaryKeySelective(Addresses record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_addresses
     *
     * @mbggenerated Mon Oct 13 11:34:37 CST 2014
     */
    int updateByPrimaryKey(Addresses record);
}