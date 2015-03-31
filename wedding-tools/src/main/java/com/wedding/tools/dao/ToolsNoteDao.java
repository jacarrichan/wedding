package com.wedding.tools.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.tools.mapper.ToolsNoteMapper;
import com.wedding.tools.pojo.ToolsNote;
import com.wedding.tools.pojo.ToolsNoteExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Repository
public class ToolsNoteDao extends MyBatisBaseDao<ToolsNote> {

    @Getter
    @Autowired
    private ToolsNoteMapper mapper;

    public List<ToolsNote> findToolsNoteByType(Integer type){
        ToolsNoteExample example = new ToolsNoteExample();
        ToolsNoteExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        example.setOrderByClause(" plan_day");
        List<ToolsNote> results = mapper.selectByExample(example);

        return CollectionUtils.isEmpty(results) ? null : results;
    }


}
