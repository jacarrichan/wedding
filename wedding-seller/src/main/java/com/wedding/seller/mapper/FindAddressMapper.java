package com.wedding.seller.mapper;

import com.wedding.seller.dto.AddressesDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FindAddressMapper {
    List<AddressesDto> findProvince();

    List<AddressesDto> findCity(@Param("proId") String proId);

}
