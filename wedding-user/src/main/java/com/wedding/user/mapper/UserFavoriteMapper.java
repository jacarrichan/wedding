package com.wedding.user.mapper;

import com.wedding.user.pojo.UserFavorite;
import com.wedding.user.pojo.UserFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFavoriteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int countByExample(UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int deleteByExample(UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int insert(UserFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int insertSelective(UserFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    List<UserFavorite> selectByExample(UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    UserFavorite selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int updateByExampleSelective(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int updateByExample(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int updateByPrimaryKeySelective(UserFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wd_user_favorite
     *
     * @mbggenerated Sat Oct 04 19:30:06 CST 2014
     */
    int updateByPrimaryKey(UserFavorite record);
}