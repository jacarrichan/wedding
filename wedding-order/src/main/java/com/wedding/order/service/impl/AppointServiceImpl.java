package com.wedding.order.service.impl;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.order.constants.AppointStatusEnum;
import com.wedding.order.dao.AppointDao;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.pojo.Appoint;
import com.wedding.order.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 14-9-19.
 */
@Service
public class AppointServiceImpl implements AppointService {

    @Autowired
    private AppointDao appointDao;



    @Override
    public void saveAppoint(AppointDto appointDto) {
        Appoint appoint = new Appoint();
        BeanUtils.copyProperties(appointDto,appoint);
        this.appointDao.insert(appoint);
    }

    @Override
    public void updateStatus(AppointDto appointDto) {
        Appoint appoint = new Appoint();
        BeanUtils.copyProperties(appointDto,appoint);
        this.appointDao.updateStatus(appoint);
    }

    @Override
    public AppointDto getAppointById(String id) {
        Appoint appoint = this.appointDao.getAppointById(id);
        AppointDto appointDto = new AppointDto();
        BeanUtils.copyProperties(appoint,appointDto);
        return appointDto;
    }

    @Override
    public PageResult<AppointDto> getAppointsBySeller(String sellerId, PageQuery pageQuery) {
        List<Appoint> result = this.appointDao.getAppointsBySeller(sellerId,pageQuery);
        List<AppointDto> list = new ArrayList<AppointDto>();
        for(Appoint appoint : result){
            AppointDto appointDto = new AppointDto();
            BeanUtils.copyProperties(appoint,appointDto);
            list.add(appointDto);
        }
        return new PageResult<AppointDto>(pageQuery,list);
    }

    @Override
    public PageResult<AppointDto> getAppointsByUser(String userId, PageQuery pageQuery) {
        List<Appoint> result = this.appointDao.getAppointByUser(userId,pageQuery);
        List<AppointDto> list = new ArrayList<AppointDto>();
        for(Appoint appoint : result){
            AppointDto appointDto = new AppointDto();
            BeanUtils.copyProperties(appoint,appointDto);
            list.add(appointDto);
        }
        return new PageResult<AppointDto>(pageQuery,list);
    }
}
