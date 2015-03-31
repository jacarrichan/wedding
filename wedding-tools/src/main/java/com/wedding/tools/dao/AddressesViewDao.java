package com.wedding.tools.dao;

import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.tools.mapper.AddressesQueryViewMapper;
import com.wedding.tools.pojo.AddressesView;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Peter on 14-10-10.
 */
@Repository
public class AddressesViewDao extends MyBatisBaseDao<AddressesView>{

    @Autowired
    @Getter
    private AddressesQueryViewMapper mapper;

    public List<AddressesView> getAddressByStr(String addressStr){
        char[] items = addressStr.toCharArray();
        return this.getMapper().getAddressByIP(items);
    }
    public String getUploadAddress(){
        return mapper.getUploadAddress();
    }
}
