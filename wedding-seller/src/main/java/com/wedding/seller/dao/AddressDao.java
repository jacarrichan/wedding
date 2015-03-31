package com.wedding.seller.dao;

import com.wedding.seller.dto.AddressesDto;
import com.wedding.seller.mapper.FindAddressMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yea01 on 2015/1/12.
 */
@Repository
public class AddressDao {

    @Autowired
    @Getter
    private FindAddressMapper mapper;

    public List<AddressesDto> findProvince(){
        return mapper.findProvince();
    }

    public List<AddressesDto> findCity(String id){return mapper.findCity(id);}
}
