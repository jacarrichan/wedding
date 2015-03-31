package com.wedding.tools.service.impl;

import com.common.util.ip.IPSeeker;
import com.wedding.common.util.BeanUtils;
import com.wedding.tool.dto.AddressesViewDto;
import com.wedding.tool.service.AddressesViewService;
import com.wedding.tools.dao.AddressesViewDao;
import com.wedding.tools.pojo.AddressesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Peter on 14-10-10.
 */
@Service
public class AddressesViewServiceImpl implements AddressesViewService {

    /**
     * IP地址搜寻
     */
    public static IPSeeker seeker = new IPSeeker("qqwry.dat","./");


    @Autowired
    private AddressesViewDao addressesViewDao;

    @Override
    public String getAddressByIP(String ipAddress) {
        String addressStr = seeker.getCountry(ipAddress);
        return addressStr;
    }

    @Override
    public AddressesViewDto getAddress(String ipAddress) {
        String addressStr = this.getAddressByIP(ipAddress);
        List<AddressesView> list = this.addressesViewDao.getAddressByStr(addressStr);
        if(list!=null&&list.size()>0){
            AddressesView addressesView =  list.get(0);
            return BeanUtils.createBeanByTarget(addressesView,AddressesViewDto.class);
        }else{
            // can't find the address in my ip store
            return null;
        }
    }

    @Override
    public String uploadAddress() {
        return addressesViewDao.getUploadAddress();
    }
}
