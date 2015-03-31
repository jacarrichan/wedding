package com.wedding.tools.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.tools.mapper.ArticleMapper;
import com.wedding.tools.pojo.Article;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Repository
public class ArticleDao extends MyBatisBaseDao<Article> {

    @Getter
    @Autowired
    private ArticleMapper mapper;



}
