package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.user.constants.RightsCenterInternalStatusEnum;
import com.wedding.user.dto.RightsCenterDto;
import com.wedding.user.service.RightsCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 14-10-9.
 */
@Controller
@RequestMapping(value = "/user/rightsCenter")
public class RightsCenterController {

    @Autowired
    private RightsCenterService rightsCenterService;


    @RequestMapping(value = "/save.do")
    @ResponseBody
    public RequestResult save(RightsCenterDto rightsCenterDto,HttpSession session){
        RequestResult result = new RequestResult();
        try {
            rightsCenterDto.setUserAccountId(session.getAttribute(SessionConstants.USER_ID).toString());
            this.rightsCenterService.save(rightsCenterDto);
            result.setSuccess(true);
            result.setMessage("维权信息保存成功");
        }catch (Exception e){
            throw new SystemException("系统异常");
        }
        return result;
    }


    @RequestMapping(value = "/findRightsCenterByUser.do")
    @ResponseBody
    public PageResult<RightsCenterDto> findRightsCenterByUser(PageQuery pageQuery,HttpSession session){
//        PageQuery pageQuery = new PageQuery();
//        pageQuery.setCurrPage(1);
//        pageQuery.setPageSize(10);
//        String userId="8798dfe6-8dcd-41da-a3ee-f5f6dde47de8";


        String userId =session.getAttribute(SessionConstants.USER_ID).toString();
        try {
            return this.rightsCenterService.searchRightsCenterAll(userId,pageQuery);
        }catch (Exception e){
            throw new SystemException("系统异常:维权信息查询异常");
        }
    }
    @RequestMapping(value="/findRightById.do")
    @ResponseBody
    public List<RightsCenterDto> findRightById(@RequestParam("dateWeek") String dateWeek,@RequestParam("dateMonth") String dateMonth,PageQuery pageQuery,HttpSession session){
//              String sellerId ="0013309a-d83f-43dd-b570-b2c9b4478c90";


        String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
       List<RightsCenterDto> list = rightsCenterService.findRightsById(dateWeek,dateMonth,pageQuery,sellerId);
        if(list!=null){
            for(RightsCenterDto rightCenterDto :list){
                rightCenterDto.setStatusName(RightsCenterInternalStatusEnum.getRightsInternalStatusName(rightCenterDto.getInternalStatus()));
            }
        }
        return list;
    }
    @RequestMapping(value="/countRightsStatus.do")
    @ResponseBody
    public Map<String,String> countRightsStatus(@RequestParam("dateWeek") String dateWeek,@RequestParam("dateMonth") String dateMonth,HttpSession session){
              String sellerId ="0013309a-d83f-43dd-b570-b2c9b4478c90";


//        String sellerId = session.getAttribute(SessionConstants.SELLER_ID).toString();
        return rightsCenterService.countRightsStatus(dateWeek,dateMonth,sellerId);
    }
    @RequestMapping(value="/revoke.do")
    @ResponseBody
    public String revoke(@RequestParam("rightId")String rightId){
          return rightsCenterService.revoke(rightId);
    }



}
