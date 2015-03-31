package com.wedding.seller.mapper;

import com.wedding.seller.pojo.Seller;
import com.wedding.seller.pojo.SellerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int countByExample(SellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int deleteByExample(SellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int insert(Seller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int insertSelective(Seller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    List<Seller> selectByExample(SellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    Seller selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int updateByExampleSelective(@Param("record") Seller record, @Param("example") SellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int updateByExample(@Param("record") Seller record, @Param("example") SellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int updateByPrimaryKeySelective(Seller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_seller
     *
     * @mbggenerated Thu Oct 16 13:19:47 CST 2014
     */
    int updateByPrimaryKey(Seller record);
}