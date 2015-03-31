package com.wedding.tools.mapper;

import com.wedding.tools.pojo.AddressesView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressesQueryViewMapper {
    List<AddressesView> getAddressByIP(@Param("items") char[] items);
    String getUploadAddress();
}