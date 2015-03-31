package com.wedding.tool.service;

import com.wedding.tool.dto.AddressesViewDto;

/**
 * Created by Peter on 14-10-10.
 */
public interface AddressesViewService {

    /**
     * 根据用户访问的IP地址获取用户地址
     * @param ipAddress
     * @return
     */
    public String getAddressByIP(String ipAddress);

    /**
     * 获取IP地址
     * @param ipAddress
     * @return
     */
    public AddressesViewDto getAddress(String ipAddress);

    /**
     * 得到上传文件地址
     */
    public String uploadAddress();
}
