package com.wedding.user.dao;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.user.dto.RightsCenterDto;
import com.wedding.user.mapper.RightsCenterMapper;
import com.wedding.user.pojo.RightsCenter;
import com.wedding.user.pojo.RightsCenterExample;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 14-10-5.
 */
@Repository
public class RightsCenterDao extends MyBatisBaseDao<RightsCenter> {

    @Autowired
    @Getter
    private RightsCenterMapper mapper;

    public List<RightsCenter> getRightsCenterByUserAccountId(String userAccountId,PageQuery pageQuery){
        RightsCenterExample example = new RightsCenterExample();
        RightsCenterExample.Criteria criteria = example.createCriteria();
        criteria.andStatEqualTo(DataStatus.ENABLED);
        criteria.andUserAccountIdEqualTo(userAccountId);
        example.setOrderByClause(" create_time desc limit " + pageQuery.getStartNum() + ", " + pageQuery.getPageSize());
        return this.mapper.selectByExample(example);
    }
    public  List<RightsCenterDto> findRightsById(String dateWeek,String dateMonth,PageQuery pageQuery,String id){
        String name = mapper.findSellerName(id);
        if(name!=null){

            return mapper.findRightById(dateWeek,dateMonth,pageQuery.getCurrPage()+"",pageQuery.getPageSize()+"",name);
        }
        return null;
    }
    public String Revoke(String id){
        try {
            mapper.revoke(id);
            return "200";
        }catch(Exception e){
            return "404";
        }
    }
    public Map<String,String>countRightsStatus(String dateWeek,String dateMonth,String id){
        String name = mapper.findSellerName(id);
        if(name!=null) {
            Map<String,String> map = new HashMap<String,String>();
            map.put("processCount",mapper.countBeingProcess(dateWeek,dateMonth,name)+"");
            map.put("surveyCount",mapper.countSurvey(dateWeek,dateMonth,name)+"");
            map.put("finishCount",mapper.countFinish(dateWeek,dateMonth,name)+"");
            return map;
        }
        return null;
    }
}
