package com.wedding.order.service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.dto.AppointDto;

/**
 * Created by Peter on 14-9-19.
 */
public interface AppointService {

    /**
     * 保存预约信息
     * @param appointDto
     */
    public void saveAppoint(AppointDto appointDto);

    /**
     * 更改预约状态
     * @param appointDto
     */
    public void updateStatus(AppointDto appointDto);

    /**
     * 依据主键获取预约
     * @param id
     * @return
     */
    public AppointDto getAppointById(String id);

    /**
     * 根据商家id获取商家预约列表
     * @param sellerId
     * @param pageQuery
     * @return
     */
    public PageResult<AppointDto> getAppointsBySeller(String sellerId,PageQuery pageQuery);

    /**
     * 根据用户id获取用户预约
     * @param userId
     * @param pageQuery
     * @return
     */
    public PageResult<AppointDto> getAppointsByUser(String userId, PageQuery pageQuery);

}
