package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.RequestResult;
import com.wedding.user.dto.UserEvaluateDto;
import com.wedding.user.service.UserEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Peter on 14-10-8.
 */
@Controller
@RequestMapping(value = "/user/evaluate")
public class UserEvaluateController {

    @Autowired
    private UserEvaluateService userEvaluateService;

    @RequestMapping("/save.do")
    @ResponseBody
    public RequestResult save(UserEvaluateDto userEvaluateDto,HttpSession session){
        // session 中获取用户编号
        userEvaluateDto.setUserId(session.getAttribute(SessionConstants.USER_ID).toString());
        RequestResult result = new RequestResult();
        try {
            this.userEvaluateService.save(userEvaluateDto);
            result.setSuccess(true);
            result.setMessage("评论保存成功");
        }catch (Exception e){
            throw new SystemException("保存出错");
        }
        return result;
    }

}
