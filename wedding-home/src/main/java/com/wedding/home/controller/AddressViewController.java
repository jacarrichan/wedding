package com.wedding.home.controller;

import com.wedding.common.model.RequestResult;
import com.wedding.tool.dto.AddressesViewDto;
import com.wedding.tool.service.AddressesViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Peter on 14-10-10.
 */
@Controller
@RequestMapping(value = "/addresses")
public class AddressViewController {

    @Autowired
    private AddressesViewService addressesViewService;

    /**
     * 获取IP地址方法
     * @param request
     * @return
     */
    private String getIPAddress(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");
        if(ip==null || ip.length()== 0 || "unkonwn".equals(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()== 0 || "unkonwn".equals(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()== 0 || "unkonwn".equals(ip)){
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip==null || ip.length()== 0 || "unkonwn".equals(ip)){
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip==null || ip.length()== 0 || "unkonwn".equals(ip)){
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据用户IP获取用户地址信息
     * @return
     */
    @RequestMapping(value = "/getAddress.do")
    @ResponseBody
    public AddressesViewDto getAddressByIP(HttpServletRequest request){
        String ipAddress = this.getIPAddress(request);
        AddressesViewDto addressesViewDto = this.addressesViewService.getAddress(ipAddress);
        if(null!=addressesViewDto){
            return addressesViewDto;
        }
        return null;
    }

}
