package com.wedding.home.controller;

import com.wedding.common.constants.SessionConstants;
import com.wedding.common.digest.MD5Coder;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.*;
import com.wedding.common.verify.VerfiyCodeConfig;
import com.wedding.common.verify.VerifyCodeGenerator;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.pojo.Appoint;
import com.wedding.order.service.AppointService;
import com.wedding.order.service.OrderService;
import com.wedding.user.constants.UserTypeEnum;
import com.wedding.user.dto.UserAccountDto;
import com.wedding.user.pojo.UserAccount;
import com.wedding.user.service.IUserAccountInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chuweifeng on 14-9-13.
 */
@Controller
@RequestMapping(value="/user")
public class UserAccountController {

    protected static final Log logger = LogFactory.getLog(UserAccountController.class);
    private static final String RESET_VALIDATE_CODE = "reset_validate_code";

    @Autowired
    private AppointService appointService;

    @Autowired
    private IUserAccountInfoService userAccountInfoService;

    @Autowired
    private SimpleSendEmailUtils simpleSendEmailUtils;

    /**
     * 分页获取用户的预约列表
     * @param session
     * @param pageQuery
     * @return
     */
    @RequestMapping(value = "/appoints.do")
    @ResponseBody
    public PageResult<AppointDto> getAppoints(HttpSession session,PageQuery pageQuery){
        try {
            String id = session.getAttribute(SessionConstants.USER_ID).toString();
            return this.appointService.getAppointsByUser(id, pageQuery);
        }catch (Exception e){
            throw new SystemException("获取用户预约信息失败！");
        }
    }

    @RequestMapping(value="/updatepwd.do")
    @ResponseBody
    public String updatepwd(@RequestParam("oldpasswd")String oldpasswd,@RequestParam("newpasswd")String newpasswd, HttpSession session) {
        logger.debug("user loging oldpasswd=" + oldpasswd + " newpasswd=" + newpasswd);
        String userAccountId = (String) session.getAttribute(SessionConstants.USER_ID);
        String md5oldPwd;//获取页面上输入的旧密码并加密校验
        try {
            md5oldPwd = MD5Coder.encodeMD5Hex(oldpasswd);
        } catch (Exception e) {
            throw new SystemException(e.getMessage(), e);
        }

        UserAccountDto userAccountDto = userAccountInfoService.findUserByAccountId(userAccountId);
        if (userAccountDto == null) {
            return JsonUtil.getJsonStr(new RequestResult(false, "用户未登录或登录过期"));
        }

        if(userAccountDto.getPassword().equals(md5oldPwd)){
            if(!StringUtils.isEmpty(newpasswd)){
                try {
                    userAccountDto.setPassword(MD5Coder.encodeMD5Hex(newpasswd));
                } catch (Exception e) {
                    throw new SystemException(e.getMessage(),e);
                }
                int result = userAccountInfoService.updateUserAccount(userAccountDto);
                if(result>0){
                    return JsonUtil.getJsonStr(new RequestResult(true, "修改密码成功"));
                }else{
                    return JsonUtil.getJsonStr(new RequestResult(false, "修改密码失败"));
                }
            }
        }
//        UserAccount userAccount = userAccountInfoService.

//            if(userAccount.getPassword().equals(md5oldPwd)){
//                if(!StringUtils.isEmpty(newpasswd)){
//                    try {
//                        userAccount.setPassword(MD5Coder.encodeMD5Hex(newpasswd));
//                    } catch (Exception e) {
//                        throw new SystemException(e.getMessage(),e);
//                    }
//                    int result = userAccountInfoService.updateUserAccount(userAccount);
//                    if(result>0){
//                        return JsonUtil.getJsonStr(new RequestResult(true, "修改密码成功"));
//                    }else{
//                        return JsonUtil.getJsonStr(new RequestResult(false, "修改密码失败"));
//                    }
//                }
//                return JsonUtil.getJsonStr(new RequestResult(false, "密码不正确"));
//            }else{
//                return JsonUtil.getJsonStr(new RequestResult(false, "密码不正确"));
//            }
//        }else{
//            return JsonUtil.getJsonStr(new RequestResult(false, "用户未登录或登录过期"));
//        }
        return JsonUtil.getJsonStr(new RequestResult(false, "用户未登录或登录过期"));
    }

    @RequestMapping(value="/login.do")
    @ResponseBody
    public String login(@RequestParam("accountName")String accountName,@RequestParam("pwd")String pwd, HttpSession session) {
        logger.debug("user login accountName=" + accountName + " pwd=" + pwd);
        String md5oldPwd;//获取页面上输入的密码并加密校验
        try {
            md5oldPwd = MD5Coder.encodeMD5Hex(pwd);
        } catch (Exception e) {
            throw new SystemException(e.getMessage(),e);
        }
        UserAccountDto userAccountDto=userAccountInfoService.checkUser(accountName,md5oldPwd);
        if(null==userAccountDto){
            return JsonUtil.getJsonStr(new RequestResult(false, "用户名密码错误"));
        }
        if(userAccountDto.getType()==UserTypeEnum.NORMALUSER.getIndex()){
            session.setAttribute(SessionConstants.USER_ID,userAccountDto.getId());
        }else if(userAccountDto.getType()==UserTypeEnum.SHOPUSER.getIndex()){
            session.setAttribute(SessionConstants.SELLER_ID,userAccountDto.getId());
        }

        return JsonUtil.getJsonStr(new RequestResult(true, "登录成功"));
    }

    @RequestMapping(value="/regUser.do")
    @ResponseBody
    public String regUser(@RequestParam("accountName")String accountName,@RequestParam("newpwd")String newpwd,@RequestParam("agpwd")String agpwd) {
        logger.debug("user regUser accountName=" + accountName +" newpwd=" + newpwd+ " agpwd=" + agpwd);
        if(newpwd==null||agpwd==null||!newpwd.equals(agpwd)){
            return JsonUtil.getJsonStr(new RequestResult(false, "两次密码输入不正确"));
        }
        UserAccountDto userAccountDto=new UserAccountDto();
        userAccountDto.setType(UserTypeEnum.NORMALUSER.getIndex());
        userAccountDto.setUserAccount(accountName);
        try {
            newpwd = MD5Coder.encodeMD5Hex(newpwd);
        } catch (Exception e) {
            throw new SystemException(e.getMessage(),e);
        }
        userAccountDto.setPassword(newpwd);
        //不用设置type默认注册为普通用户
        int result=userAccountInfoService.regUserAccount(userAccountDto);
        if (result>0){
            return JsonUtil.getJsonStr(new RequestResult(true, "新建用户成功"));
        }
        return JsonUtil.getJsonStr(new RequestResult(false, "新建用户失败"));
    }

    @RequestMapping(value="/resetPassword.do")
    @ResponseBody
    public String resetPassword(@RequestParam("accountName")String accountName,
                                @RequestParam("checkCode")String checkCode,
                                HttpSession session,HttpServletResponse response) {
        logger.debug("user resetPassword accountName=" + accountName +" checkCode=" + checkCode+" seesionCode= "+session.getAttribute(RESET_VALIDATE_CODE));
        String systemCode= (String) session.getAttribute(RESET_VALIDATE_CODE);
//        String systemCode="111";
        if (null!=systemCode&&checkCode!=null&&checkCode.toUpperCase().equals(systemCode.toUpperCase())){
            UserAccountDto userAccountDto=userAccountInfoService.findUserByName(accountName);
            if(userAccountDto==null){
                return JsonUtil.getJsonStr(new RequestResult(false, "无此用户"));
            }
            if(accountName.indexOf("@")>0){
                boolean isSender=sendResetPassword(userAccountDto,response);
                if(isSender){
                    return JsonUtil.getJsonStr(new RequestResult(true, "发送重置密码链接成功"));
                }
                return JsonUtil.getJsonStr(new RequestResult(false, "发送重置密码链接失败"));
            }else{
                System.out.print("");
                //TODO
                //生成新密码
                //手机用户发短信
            }
        }
        session.removeAttribute(RESET_VALIDATE_CODE);
        return JsonUtil.getJsonStr(new RequestResult(false, "验证码错误"));
    }

    @RequestMapping(value="/resetPWD.do")
    @ResponseBody
    public String resetPassword(@RequestParam("accountName")String accountName,
                                @RequestParam("newpwd")String newpwd,
                                @RequestParam("agpwd")String agpwd,
                                @RequestParam("token")String token,
                                HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        String cookieToken="";
        for (Cookie cookie : cookies) {
            if ("pwdToken".equals(cookie.getName())) {
                cookieToken = cookie.getValue();
            }
        }
        logger.debug("user resetPassword accountName=" + accountName +" token=" + token+" cookieToken="+cookieToken);
        if(cookieToken.equals(token)){
            UserAccountDto userAccountDto=new UserAccountDto();
            if(newpwd==null||agpwd==null||!newpwd.equals(agpwd)){
                return JsonUtil.getJsonStr(new RequestResult(false, "两次密码输入不正确"));
            }
            try {
                newpwd = MD5Coder.encodeMD5Hex(newpwd);
            } catch (Exception e) {
                throw new SystemException(e.getMessage(),e);
            }
            userAccountDto.setPassword(newpwd);
            userAccountDto.setUserAccount(accountName);
            int result=userAccountInfoService.updateUserAccountByAccountName(userAccountDto);
            if(result>0){
                return JsonUtil.getJsonStr(new RequestResult(true, "重置密码成功"));
            }
            return JsonUtil.getJsonStr(new RequestResult(false, "重置密码失败"));
        }
        return JsonUtil.getJsonStr(new RequestResult(false, "密钥错误"));
    }

    @ResponseBody
    @RequestMapping(value="/image.do")
    public void createImage(HttpServletRequest req, HttpServletResponse resp){
        VerfiyCodeConfig config = new VerfiyCodeConfig();
        config.setHeight(35);
        config.setWidth(100);
        config.setSessionKey(RESET_VALIDATE_CODE);
        VerifyCodeGenerator.createImage(req, resp, config);
    }

    private boolean sendResetPassword(UserAccountDto userAccountDto,HttpServletResponse response){
        String token=UUIDGenerator.getUUID32Bit();
        Cookie cookie=new Cookie("pwdToken",token);
        cookie.setMaxAge(900);
        response.addCookie(cookie);
        SpringMailMessage springMailMessage=new SpringMailMessage();
        springMailMessage.setSubject("聚喜网密码重置链接");
        springMailMessage.setFrom("tanjiaqing86@126.com");
        springMailMessage.setText("http://localhost:8080/home/resetPWD.jsp?userId="
                + userAccountDto.getId() + "&token=" + token);
        springMailMessage.setTo(userAccountDto.getUserAccount());
        try {
            simpleSendEmailUtils.sendHtmlEmail(springMailMessage,"forget_password.ftl");
            return true;
        } catch (Exception e) {
            throw new SystemException(e.getMessage(),e);
        }
    }
}
