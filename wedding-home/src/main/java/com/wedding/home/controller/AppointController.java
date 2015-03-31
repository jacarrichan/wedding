package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.StringUtils;
import com.wedding.order.constants.AppointStatusEnum;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Peter on 14-9-15.
 */
@Controller
@RequestMapping("/appoint")
public class AppointController {

    @Autowired
    private AppointService appointService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,"appointTime", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }
    @RequestMapping(value = "/save.do")
    @ResponseBody
    public RequestResult buildAppoint(AppointDto appointDto,HttpSession session){
        RequestResult result = new RequestResult();
       try {
           appointDto.setUserId(session.getAttribute(SessionConstants.USER_ID).toString());
           appointDto.setAppointStatus(Byte.valueOf(AppointStatusEnum.APPOINT_STATUS_CREATED.getIndex()+""));
           this.appointService.saveAppoint(appointDto);
           result.setMessage("预约成功");
           result.setSuccess(true);
       }catch (Exception e){
           throw new SystemException("系统异常"+e.getMessage());
       }
       return result;
    }

    /**
     * 获取当前登录用户的预约单列表
     * **/
    @RequestMapping(value = "/show.do")
    @ResponseBody
    public PageResult<AppointDto> show(AppointDto appointDto,HttpSession session,PageQuery pageQuery){
        PageResult<AppointDto> result = new PageResult<AppointDto>();
        try {
            if (!StringUtils.isEmpty(session.getAttribute(SessionConstants.USER_ID).toString())) {
                result = appointService.getAppointsByUser(session.getAttribute(SessionConstants.USER_ID).toString(), pageQuery);
            }
        }catch(Exception e){

        }finally{

        }
        try {
            if(!StringUtils.isEmpty(session.getAttribute(SessionConstants.SELLER_ID).toString())) {
                result = appointService.getAppointsBySeller(session.getAttribute(SessionConstants.SELLER_ID).toString(),pageQuery);
            }
        }catch(Exception e){

        }finally{

        }
        return result;
    }


}
