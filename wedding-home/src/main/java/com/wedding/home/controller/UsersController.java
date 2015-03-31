package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.JsonUtil;
import com.wedding.common.util.StringUtils;
import com.wedding.user.dto.UserAccountDto;
import com.wedding.user.dto.UsersDto;
import com.wedding.user.service.IUserAccountInfoService;
import com.wedding.user.service.IUsersService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by chuweifeng on 14-9-15.
 */
@Controller
@RequestMapping(value="/umanage")
public class UsersController {

    protected static final Log logger = LogFactory.getLog(UsersController.class);


    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private IUserAccountInfoService iUserAccountInfoService;

    @RequestMapping(value="/modifyInfo.do")
    @ResponseBody
    public String modifyInfo(HttpSession session,UsersDto usersDto) {

        String userAccountId = (String)session.getAttribute(SessionConstants.USER_ID);
        if(!StringUtils.isEmpty(userAccountId)){
            int result= 0;
            UsersDto oldUserDto =  iUsersService.selectUsersByUserId(userAccountId);
            if(oldUserDto!=null){//修改
                result = iUsersService.updateUsers(usersDto);
            }else{//新增
                result = iUsersService.insertUsers(usersDto);
            }
            if (result>0){
                return JsonUtil.getJsonStr(new RequestResult(true, "用户信息保存成功"));
            }
        }
        return JsonUtil.getJsonStr(new RequestResult(false, "用户信息保存失败"));
    }

}
